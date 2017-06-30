name := """$name$"""

version := "$version$"

organization := "$organisation$"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "$scalatest_version$" % Test,
  "org.scalacheck" %% "scalacheck" % "$scalacheck_version$" % Test
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

// Doctest setup
doctestWithDependencies := false
doctestTestFramework := DoctestTestFramework.ScalaTest

wartremoverErrors in (Compile, compile) ++= Warts.unsafe

scalafmtOnCompile := true