fat-auto-browser
================

This is a sbt project to run selenium, scala and scalatest together in one fat jar-file.

I'm planning to use it to run automated web tests with some basic sanity check. As this will be run on a remote server
without a window manager and real webbrowser I use Selenium's HtmlUnitDriver.


To generate a "fat jar", invoke

    sbt assembly

This jar could then be run standalone with

    java -jar target/AutoBrowser-assembly-0.1-SNAPSHOT.jar

or with

    java -cp target/AutoBrowser-assembly-0.1-SNAPSHOT.jar org.scalatest.tools.Runner -o -s com.mblund.autoBrowser.tests.CheckGoogleTest


