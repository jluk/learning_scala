scalaVersion := "2.11.5"

organization := "net.s_mach"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation")

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
