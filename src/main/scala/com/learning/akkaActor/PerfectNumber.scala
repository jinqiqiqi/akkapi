package com.learning.akkaActor


object PerfectNumber extends App {

  def sumOfFactors(number: Int) = {
    println(s"sum of $number")
    (0 /: (1 to number)) { (sum, i) =>
      if(number % i == 0) sum +i else sum}
  }

  def isPerfect(candidate: Int) = sumOfFactors(candidate)

  val t = List(2147483647, 6000000, 6500000, 6400000, 3000000, 4000000, 2100000)
  for (n <- t)
    println(s"$n => " + isPerfect(n))

}
