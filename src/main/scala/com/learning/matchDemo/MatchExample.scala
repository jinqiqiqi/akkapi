package com.testing.matchDemo

/**
	* Created by kinch on 1/28/16.
	*/
object MatchExample extends App {

	List(DayOfWeek.MONDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY).foreach(activity)
	
	processCoordinates((39, -104))
	processCoordinates("done")
	processCoordinates(DayOfWeek.SUNDAY)

	println("=============================")

	processItems(List("apple", "ibm"))
	processItems(List("red", "blue", "green"))
	processItems(List("red", "blue", "white"))
	processItems(List("apple", "orange", "grapes", "dates"))

	println("=============================")

	process((34.2, -159.3))
	process(0)
	process(100001)
	process(2.2)
	process("China")

	def process(input: Any) = {
		input match {
			case (a: Int, b: Int) => println("Processing (int, int) ...")
			case (a: Double, b: Double) => println("Processing (double, double) ...")
			case msg: Int if (msg > 100000) => println("Processing int > 100000")
			case msg: Int => println("Processing int ...")
			case msg: String => println(s"Processing string ...: $msg")
			case _ => printf("Can't handle %s ...", input); println(s"getclass: ", input.getClass)
		}
	}

	def activity(day: DayOfWeek.Value) = {
		day match {
			case DayOfWeek.SUNDAY => print("Eat, sleep, repeat ...")
			case DayOfWeek.SATURDAY => print("Hangout with friends ...")
			case DayOfWeek.MONDAY => print("... code for fun ...")
			case DayOfWeek.FRIDAY => print(".. read a good book ...")
			case _ => 
		}
	}
	
	def processCoordinates(input: Any) {
		input match {
			case (a, b) => printf("Processing (%d, %d) ...", a, b)
			case "done" => println("Done")
			case DayOfWeek.SUNDAY => println("Eat, Sleep, Repeat ...")
			case _ => 
		}
	}

	def processItems(items: List[String]) = {
		items match {
			case List("apple", "ibm") => println("Apples and IBMs")
			case List("red", "blue", "green") => println("Stars and Stripes...")
			case List("red", "blue", _*) => println("colors red, blue, ...")
			case List("apple", "orange", otherFruits @ _*) => println("apples, orange, and " + otherFruits)
		}
		
	}

}

object DayOfWeek extends Enumeration {
	val SUNDAY = Value("Sunday")
	val SATURDAY = Value("Saturday")
	val MONDAY = Value("Monday")
	val TUESDAY = Value("Tuesday")
	val WEDNESDAY = Value("Wednesday")
	val THURSDAY = Value("Thursday")
	val FRIDAY = Value("Friday")
}
	
