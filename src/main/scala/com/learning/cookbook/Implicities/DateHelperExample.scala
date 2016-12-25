package com.learning.cookbook.Implicities

import DateHelper._
// import com.learning.cookbook.Implicities.DateHelper

/**
  * Created by kinch on 1/26/16.
  */
object DateHelperExample extends App {


  val past = 2 days ago
  val appointment = 5 days from_now

  println(s"past: $past")
  println(s"appointment: $appointment")
}
