lazy val root = (project in file(".")).
  settings(
    resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns))
    scalaVersion in ThisBuild := "2.12.6"
    scalacOptions in ThisBuild ++= Seq(
      "-language:_",
      "-Ypartial-unification",
      "-Xfatal-warnings")

    libraryDependencies ++= Seq(
      "com.github.pathikrit" %% "better-files" % "3.5.0",
      "com.github.mpilquist" %% "simulacrum"   % "0.12.0",
      "org.scalaz"           %% "org.scalaz"   % "scalaz-core" % "7.2.25",
      "org.scalaz"           %% "zio"          % "0.1-SNAPSHOT",
      "org.scalacheck"       %% "scalacheck"   % "1.14.0" % "test"
    )

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
