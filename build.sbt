name := """proyAdmin"""
organization := "com.rafaels"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.8.1"
// https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.1"
libraryDependencies += guice
libraryDependencies ++= Seq(
 javaJdbc,
  "mysql" % "mysql-connector-java" % "5.1.41",
  javaJpa,
  "org.hibernate" % "hibernate-core" % "5.4.9.Final"
)


libraryDependencies += javaWs % "test"

libraryDependencies += "org.awaitility" % "awaitility" % "3.1.5" % "test"
libraryDependencies += "org.assertj" % "assertj-core" % "3.11.1" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "2.23.4" % "test"

Test / testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-v")

ThisBuild / scalacOptions ++= List("-encoding", "utf8", "-deprecation", "-feature", "-unchecked")
ThisBuild / javacOptions ++= List("-Xlint:unchecked", "-Xlint:deprecation", "-Werror")

PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" / "persistence.xml"
