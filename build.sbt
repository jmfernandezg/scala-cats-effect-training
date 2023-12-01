ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file(".")).settings(
  name := "joses-cats-effect-3-training-app",
  libraryDependencies ++= Seq(
    // "core" module - IO, IOApp, schedulers
    // This pulls in the kernel and std modules automatically.
    "org.typelevel" %% "cats-effect" % "3.6-0142603",
    // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
    "org.typelevel" %% "cats-effect-kernel" % "3.6-0142603",
    // standard "effect" library (Queues, Console, Random etc.)
    "org.typelevel" %% "cats-effect-std" % "3.6-0142603",
    "org.typelevel" %% "cats-effect-testing-specs2" % "1.5.0" % Test,
    "org.typelevel" %% "munit-cats-effect" % "2.0-5e03bfc" % Test
  )
)
