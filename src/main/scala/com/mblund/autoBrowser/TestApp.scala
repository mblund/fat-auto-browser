package com.mblund.autoBrowser

import org.scalatest.tools.Runner

/***
 * Just a main app to enable java -jar AutoBrowser-assembly-0.1-SNAPSHOT.jar
 */
object TestApp extends App {
  Runner.run(Array("-o", "-s", "com.mblund.autoBrowser.tests.CheckGoogleTest"))
}
