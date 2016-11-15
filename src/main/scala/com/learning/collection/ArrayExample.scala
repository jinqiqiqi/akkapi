package com.testing.collection

object ArrayExample extends App {
  
  // for sorting
  val fruits = Array("cherry", "apple", "banana", "grape", "pair")
  
  println("Before sorting:")
  fruits.map{println}
  
  scala.util.Sorting.quickSort(fruits)
  
  println("After sorting:")
  fruits.map{println}
  
  
  // for multi-dimension array
  
  val rows = 2
  val cols = 3
  
  val a = Array.ofDim[String](rows, cols)
  a(0)(0) = "a"
  a(0)(1) = "b"
  a(0)(2) = "c"
  a(1)(0) = "d"
  a(1)(1) = "e"
  a(1)(2) = "f"
  
 for{
   i <- 0 until rows
   j <- 0 until cols
 } {
   println(s"a($i)($j) = ${a(i)(j)}")
 }
 
 println()
 val x, y, z = 10
 val b = Array.ofDim[Int](x, y, z)
 for {
   i <- 0 until x
   j <- 0 until y
   k <- 0 until z
 } println(s"b($i)($j)($k) = ${b(i)(j)(k)}")
  
}



