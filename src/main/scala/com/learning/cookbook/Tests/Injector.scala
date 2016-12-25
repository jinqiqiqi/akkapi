package com.learning.cookbook.Tests

/**
  * Created by kinch on 11/20/16.
  */
object Injector extends App {


  val array = Array(2,3,6,4,88,19)
  val sum =inject(array, 0, (carryOver, elem) => carryOver + elem)

  println(s"Sum (inject) is $sum")

  val s = (0 /: array) { (sum, elem) =>
    sum + elem
  }
  println(s"Sum (foldLeft) $s")

  def inject(arr: Array[Int], initial: Int, operation: (Int, Int) => Int): Int = {
    var carryOver = initial
    arr.foreach(element => carryOver = operation(carryOver, element))
    carryOver
  }
}
