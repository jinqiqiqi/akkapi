package com.testing.test

import scala.concurrent.duration.DurationConversions.spanConvert.R

/**
  * Created by kinch on 12/25/15.
  */
object TestingApp extends App {



  val book = if (false) "nick"



  println(book)

  val xs = Seq(3 , 2, 1)
  val ys = Seq(30 , 20, 10)

  val zipped = xs zip ys


  val a = for ((x, y) <- zipped) yield x*y

  val b = zipped map {
    case (x, y) => x*y
  }

  println(a)
  println(b)
  println(zipped)

  println("+++++++++++++++++++++++++++++++++++++++++++++++++++++")

  val c = for(x <- xs; y <- ys) yield x*y
  val d = xs flatMap {
    x => ys map {y => x*y}
  }


  println(c)
  println(d)

  println("+++++++++++++++++++++++++++++++++++++++++++++++++++++")

  val e = for(x <- xs; y <- ys) {
    println("%d/%d = %d".format(x,y, x*y))
  }
  println("+++++++++++++++++++++++++++++++++++++++++++++++++++++")


  val UppercaseVal = 32
  Some(32) match {
    case Some(`UppercaseVal`) => println(UppercaseVal)
    case _ => println("Not v42")
  }


  val set = new scala.collection.mutable.LinkedHashSet[Any]
  set += "This is a string"  // add a string
  set += 732                 // add a number
  set += 'c'                 // add a character
  set += true                // add a boolean value
  set += main _              // add the main function
  val iter: Iterator[Any] = set.iterator
  while (iter.hasNext) {
    println(iter.next.toString())
  }



}

class C(x: R)

class D(private val x: R)
