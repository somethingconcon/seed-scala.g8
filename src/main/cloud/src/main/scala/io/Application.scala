package io

import scalaz.zio.{IO, IOApp}
import scalaz.zio.console._

import java.io.IOException

/**
  * VM is the domain of resource managment for applications
  *   - manages
  *     + open connections
  *       = Connection[F, Local, Cluster]
  */
object VM extends IOApp {

  def run(args: List[String]): IO[Void, ExitStatus] = {
    appLogic.attempt.map(_.fold(_ => 1 _ => 0)).map(ExitStatus.ExitNow(_))
  }

  def appLogic: IO[IOException, Unit] =
    for {
      _ <- printStrLn("Suh")
      n <- getStrLn
      _ <- printStrLn("Fuck off")
    } yield ()
}
