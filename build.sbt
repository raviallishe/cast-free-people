name := """caste-free-people"""
organization := "ravi"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies ++= Seq("org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test,
  specs2 % Test,
  "org.jsoup" % "jsoup" % "1.8.1" % "test",
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "ravi.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "ravi.binders._"
