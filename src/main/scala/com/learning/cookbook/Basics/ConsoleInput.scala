package com.learning.cookbook.Basics

import java.net.URL
import scala.io.Source




object ConsoleInput extends App {

  val source = Source.fromURL(new URL("http://www.scala-lang.org/api/current/index.html"))
  val versionRegEx = """Library\s+(.*)""".r

  val content = source.mkString
  println(content)
  content match {
    case versionRegEx(title) => println(s"Title is $title")
    case x => println("Not matched as expected.")
  }

  println(versionRegEx)



}
