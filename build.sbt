import sbt._
import Keys._

val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val root = Project("root", file("."))
  .configs(JenkinsTest)
  .settings( inConfig(JenkinsTest)(Defaults.testTasks) : _*)
  .settings(
  scalaVersion := "2.12.1",
    libraryDependencies += scalatest,
    testOptions in JenkinsTest := Seq(),
    testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-l", "tags.RequiresDb")
)

lazy val JenkinsTest = config("jenkins").extend(Test)
