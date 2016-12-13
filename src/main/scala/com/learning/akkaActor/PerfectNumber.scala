package com.learning.akkaActor


object PerfectNumber extends App {

  val startTime = System.nanoTime()

  def sumOfFactors(number: Int) = {
    println(s"sum of $number")
    (0 /: (1 to number)) { (sum, i) =>
      if(number % i == 0) sum +i else sum}
  }

  def isPerfect(candidate: Int) = sumOfFactors(candidate)

  val t = List(1674836470)
  for (n <- t)
    println(s"$n => " + isPerfect(n))

  val diff = (System.nanoTime() - startTime)/1000000000.0
  println(s"Total in $diff seconds")

}
