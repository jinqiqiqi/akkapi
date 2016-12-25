package com.learning.cookbook.Collections

/**
  * Created by kinch on 12/26/15.
  */
object TupleExample extends App{
  val symbols = Array("<", "=", ">")
  val counts = Array(2, 4, 6)
  val pairs = symbols.zip(counts)

  val cp = counts.zip(symbols)

  println(pairs.toMap)

//  (pairs ++ cp).toMap match {
//    case (x, y) => println(s"$x, =: $y")
//  }
}
