ThisBuild / organization := "com.jmfg"
ThisBuild / scalaVersion := "3.3.1" // updated 2023-09-05

lazy val root = (project in file(".")).settings(
  name := "joses-cats-effect-3-training-app",
  libraryDependencies ++= Seq(
    // 3.6-0142603 updated 2023-05-29
    "org.typelevel" %% "cats-effect" % "3.6-0142603",
    "org.typelevel" %% "cats-effect-kernel" % "3.6-0142603",
    "org.typelevel" %% "cats-effect-std" % "3.6-0142603",

    "org.typelevel" %% "cats-effect-testing-specs2" % "1.5.0" % Test,
    "org.typelevel" %% "munit-cats-effect" % "2.0-5e03bfc" % Test // 2022-09-09
  )
)
