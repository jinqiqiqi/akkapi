package com.testing.akkaActor

import com.testing.test.StringUtils
import StringUtils.StringImprovements

/**
  * Created by kinch on 12/4/15.
  */
object HelloWorld extends App {
    
	val car = new Car
		car.turn("left")
}



class Car {
	def turn(direction: String) = {
		println("Turning: "+ direction)
	}
}


