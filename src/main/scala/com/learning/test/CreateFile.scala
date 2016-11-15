package com.learning.test

import java.io._

/**
  * Created by kinch on 1/12/16.
  */
object CreateFile extends App {
  val pw = new PrintWriter(new File("hi.txt"))
  pw.println("你好")
  pw.println("j")
  pw.println("jj")
  pw.close()
}
