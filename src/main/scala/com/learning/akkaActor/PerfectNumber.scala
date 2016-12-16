package com.learning.akkaActor

import java.io.File
import java.util.Date



object PerfectNumber extends App {

  val startTime = System.nanoTime()

  def sumOfFactors(number: Int) = {
    println(s"sum of $number")
    (0 /: (1 to number)) { (sum, i) =>
      if(number % i == 0) sum +i else sum}
  }

  def jack() = {
    val dd = new Date()


  }

  def isPerfect(candidate: Int) = sumOfFactors(candidate)

//   val t = List(36470)
//   for (n <- t)
//     println(s"$n => " + isPerfect(n))

  val diff = (System.nanoTime() - startTime)/1000000000.0
  println(s"Total in $diff seconds")


  val files = new File(".").listFiles()
  for(f <- files ) {
    println(f)
  }

  
}
