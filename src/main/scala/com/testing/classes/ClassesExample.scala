package com.testing.classes

/**
  * Created by kinch on 12/26/15.
  */

class Counter {
  private var value = 0
  def increment = value += 1
  def decrement = value -= 1
  def current = value
}
object ClassesExample extends App{
  val myCounter = new Counter()

  myCounter.increment
  myCounter.increment
  myCounter.increment
  myCounter.increment
  myCounter.increment
  myCounter.decrement

  val x = myCounter.current
  println(x)
}
