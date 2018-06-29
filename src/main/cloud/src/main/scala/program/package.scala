package io

import scalaz._
import Scalaz._

package object program {
  object api {

    case class Config(data: String) extends AnyVal
    case class Program(config: Config) extends AnyVal

    // make this type easier to talk about

    object events {
      type FUNK = List[Event[_]]
      type Partner = String
      type Handle = String
      type Properties = (Handle, Partner)
      type Application[+A] = (Event, Properties)

      type Work[+A] = State[Application[A], FUNK]
    }


    object Program {

      type File = java.nio.File
      type Partner = String

      // add relevant details to
      // the Event domain
      /**
        *  @param file: File
        *  @param partner: Partner
        */
      sealed trait Event {
        val file: File
        val p: Partner
      }
      final case class Trigger(file: File, p: Partner) extends Event
      final case class Notify(file: File, p: Partner) extends Event
      final case class Finished(file: File, p: Partner) extends Event

      implicit class EventSyntax(e: Event) {

      }

      def process(f: Event): Work[Event] = {
        State { ((event, properties), events) =>
          if properties.handle(event)
            f((event.next, properties), event :: events)
          else f((event.pass), skipWithNoop(event))
        }
      }
    }

    def apply(config: Config) = {
      Program(config)
    }
  }
}
