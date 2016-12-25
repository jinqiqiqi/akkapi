package com.learning.cookbook.Tests

/**
  * Created by kinch on 12/8/15.
  */
object LargeMatchTest extends App {
  case class Person(firstName: String, lastName: String)
  case class Dog(name: String)

  println(echoWhatYouGaveMe(List("ss", "yes", "no", "Kinch")))

  def echoWhatYouGaveMe(x: Any): String = x match {

    //constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said 'hello'"
    case Nil => "an empty List"

    //sequence patterns
    case List(0, _, _) => "a three-element list with 0 as the first element"
    case List(1, _*) => "a list beginning with 1, having any number of elements"
    case Vector(1, _*) => "a vector starting with 1, having any number of elements"

    // tuples
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b and $c"


    // constructor parttens
    case Person(first, "Kinch") => s"found a Kinch, first name is '$first'"
    case Dog("Suka") => "found a dog named Suka"

    // typed patterns

    case s: String => s"You gave me this string: $s"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case d: Dog => s"dog: ${d.name}"
    case list: List[_] => s"thanks for the List: $list"
    case m: Map[_, _] => m.toString

    case _ => "Unknow"

  }

}
