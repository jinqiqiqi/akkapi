package com.learning.test

/**
  * Created by kinch on 1/12/16.
  */
object ReadFile extends App {
  val source = io.Source.fromFile("hi.txt")
  for (char <- source) {
    println(char)
  }
}
