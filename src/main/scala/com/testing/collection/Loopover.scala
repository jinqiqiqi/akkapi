package com.testing.collection

/**
  * Created by kinch on 12/21/15.
  */
object Loopover extends App{
  val x = Vector(1, 2, 3)
  x.foreach((i: Int) => println(i))

  x.foreach(i => println(i))

  x.foreach((println(_)))

  x.foreach(println)


  val longWords = new StringBuilder

  "Hello world it's Al".split(" ").foreach(e => if (e.length > 4) longWords.append(s"_${e}") else println("Not Added: "+ e))

  println(s" result: $longWords")


  val m = Map("fname" -> "Tyler", "lname" -> "LeDude")
  m foreach( x => println(s"${x._1} -> ${x._2}"))

  m.foreach{

    case(name, value) => println(s"$name => $value")
  }


//  ##########

  val fruits = Traversable("apple", "banana", "orange", "pear", "cake")

  for (f <- fruits) println(f)
  println("___")
  for (f <- fruits) println(f.toUpperCase)

  println("####")

  for (f <- fruits) {
    val s = f.toUpperCase
    println(s)
  }


  println("======")

  println(fruits.zipWithIndex)

}
