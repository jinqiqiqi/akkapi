package com.learning.test

/**
  * Created by kinch on 11/20/16.
  */
object Equipment extends App {


  val calculator = { input: Int =>
    println("calc with " + input)
    input
  }

  val eqip1 = new Equip(calculator)
  val eqip2 = new Equip(calculator)

  eqip1.simulate(4)
  eqip1.simulate(6)


  class Equip(val routine: Int => Int) {
    def simulate(input: Int) = {
      println("Running simulation...")
    }
  }

}
