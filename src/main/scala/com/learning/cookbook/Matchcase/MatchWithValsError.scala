package com.learning.cookbook.Matchcase

object MatchWithValsError extends App {
  println("==]\n")
  val sample = new Sample()
  sample.process(100)
  sample.process(0)
  sample.process(10)
  println("\n==]")
}


class Sample() {
  val max = 100
  val MIN = 0

  def process(input: Int) = {
    input match {
      case this.max => println("Don't try this at home")
      case MIN => println("You matched min")
      case _ => println("Unreachable!!")
    }
    
  }
}