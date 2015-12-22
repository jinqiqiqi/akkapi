package com.testing.collection

/**
  * Created by kinch on 12/21/15.
  */
object VectorExample extends App{
  val fruits = Array("apple", "banana", "lime", "orange")
  
  val ucFruits = for(e <- fruits) yield e.toUpperCase
  println(ucFruits)
  
  val vFruits = for(i <- 0 until fruits.size) yield (i, fruits(i))
  println(vFruits)
}
