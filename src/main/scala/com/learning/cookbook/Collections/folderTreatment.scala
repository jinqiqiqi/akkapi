package com.learning.cookbook.Collections

/**
  * Created by kinch on 1/13/16.
  */
object folderTreatment extends App {
  val findMax = (x: Int, y: Int) => {
    Thread.sleep(10)
    val winner = x max y
    println(s"Compared $x to $y, $winner was larger;")
    winner
  }

  val a = Array.range(0, 50)
  a.par.reduce(findMax)
}
