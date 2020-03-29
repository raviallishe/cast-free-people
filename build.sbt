name := """caste-free-people"""
organization := "ravi"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies ++= Seq("org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test,
  specs2 % Test,
  "org.jsoup" % "jsoup" % "1.8.1" % "test",
  "com.github.simplyscala" %% "scalatest-embedmongo" % "0.2.4",
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.4.2"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "ravi.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "ravi.binders._"
