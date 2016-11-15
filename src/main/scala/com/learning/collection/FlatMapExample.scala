package com.learning.collection

/**
  * Created by kinch on 12/22/15.
  */
object FlatMapExample extends App{
  val bag = List("1", "2", "three", "4", "one hundred seventy five")



  def toInt(i: String): Option[Int] = {
    try {
        Some(Integer.parseInt(i.trim))
    }
    catch {
      case e: Exception => None
    }
  }
  println(bag.map(toInt).flatten)
  println(bag.flatMap(toInt))
  println(bag.flatMap(toInt).sum)

  println(bag.flatMap(toInt).partition( _ > 3))
}
