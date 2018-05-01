name := """MeeCarros"""
organization := "com.aaascp"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += filters
libraryDependencies ++= Seq(
  javaJdbc,
  "org.xerial" % "sqlite-jdbc" % "3.21.0.1",
  "com.zsoltfabok" % "sqlite-dialect" % "1.0")
libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-core" % "5.2.17.Final",
  "org.hibernate" % "hibernate-entitymanager" % "5.2.17.Final"
)

PlayKeys.externalizeResources := false