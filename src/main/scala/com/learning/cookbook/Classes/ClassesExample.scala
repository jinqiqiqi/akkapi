package com.learning.cookbook.Classes

/**
  * Created by kinch on 12/26/15.
  */

class Counter {
  private var value = 0
  def increment = {
    value += 1
    value
  }
  def decrement = {
    value -= 1
    value
  }
  def current = value
}
object ClassesExample extends App{
  val myCounter = new Counter()

  myCounter.increment
  myCounter.increment
  myCounter.increment
  myCounter.increment
  myCounter.increment
  val y = myCounter.decrement
  myCounter.increment

  val x = myCounter.current
  println(x)
  println(y)
}
