package com.testing.collection

object MapExample extends App {
  
  // get elements
  val states = Map("AL" -> "Alabama", "AK" -> "Alaska", "AZ" -> "Arizona").withDefaultValue("NotFound")
  
  println(states("AKf"))
  println(states.getOrElse("AZx", "e"))
  
  
//  traversing a map
  val ratings = Map("Lady in the Water" -> 3.0, "Snakes on a Plane" -> 4.0, "You, Me and Dupree" -> 3.5)
  for ((k, v) <- ratings) println(s"key: $k, value: $v")
  
  ratings.foreach{
    case (k, v) => println(s"k: $k, v: $v")
  }
  
  ratings.foreach(x => 
    println(s"t_name: ${x._1}, t_value: ${x._2}")
  )
  
  println()
  
  ratings.keys.foreach { println }
  ratings.values.foreach { println }
  
  
  println()
  
  
  println(ratings.mapValues {  2* _ })
  
  
  println()
  println("Transform new map")
  val map = Map(1 -> 10, 2 -> 20, 3 -> 30)
  val newMap = map.transform((k, v) => k + v)
  println(newMap)
  
  
  
}
