package com.learning.akkaActor


object PerfectNumber extends App {

  def sumOfFactors(number: Int) = {
    (0 /: (1 to number)) { (sum, i) =>
      if(number % i == 0) sum +i else sum}
  }

  def isPerfect(candidate: Int) = 2 * candidate == sumOfFactors(candidate)

  val t = List(395503569, 395506369, 395593369, 395502369, 395523369, 395503349)
  for (n <- t)
    println(s"$n is perfect? " + isPerfect(n))

}
