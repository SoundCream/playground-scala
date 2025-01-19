name := """play-scala"""
organization := "n4a3.play"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.15"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

libraryDependencies ++= Seq(
  "com.github.swagger-akka-http" %% "swagger-akka-http" % "2.11.0",
  "io.swagger.core.v3" % "swagger-core" % "2.2.27",
)

//"com.iheart" %% "play-swagger" % "1.0.2",
//"io.swagger" % "swagger-annotations" % "1.6.15"

dependencyOverrides ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.15.0"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "n4a3.play.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "n4a3.play.binders._"

