import sbt._
import sbt.Keys._
import sbtassembly.Plugin._
import AssemblyKeys._


object ProjectBuild extends Build {

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = Project.defaultSettings ++ assemblySettings ++ Seq(
      name := "AutoBrowser",
      organization := "com.mblund",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.1",
      libraryDependencies ++= Seq(
        "junit"             % "junit"           % "4.5",
        "org.scalatest"     % "scalatest_2.9.0" % "1.6.1",
	      "org.seleniumhq.selenium" % "selenium" % "2.0rc2",
        "org.seleniumhq.selenium" % "selenium-server" % "2.20.0",
        "org.seleniumhq.selenium" % "selenium-java" % "2.20.0",
        "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.20.0",
        "org.apache.httpcomponents" % "httpclient" % "4.1.3"
      ),
      excludedFiles in assembly := excludedFileList
      // add other settings here
    )
  )
  //TODO: check dep.

  //Got problem with signed jars. Works when I exclude some files
  //http://stackoverflow.com/questions/999489/invalid-signature-file-when-attempting-to-run-a-jar
  //
  //see also
  //https://github.com/sbt/sbt-assembly/issues/11
  //
  //TODO:fix license files

  val excludedFileList = {
    (bases: Seq[File]) =>
      bases flatMap {
        base =>
          ((base / "META-INF" * "*").get ++ (base * "*").get) collect {
            case f if f.getName.endsWith(".SF") =>  f
            case f if f.getName.endsWith(".DSA") =>  f
            case f if f.getName.endsWith(".RSA") =>  f
            case f if f.getName.toLowerCase == "license" =>  f
            case f if f.getName.toLowerCase == "manifest.mf" =>  f
          }
      }
  }

}
