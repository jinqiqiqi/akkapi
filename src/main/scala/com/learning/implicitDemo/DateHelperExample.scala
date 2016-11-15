package com.testing.implicitDemo

import java.util._
import DateHelper._
/**
  * Created by kinch on 1/26/16.
  */
object DateHelperExample extends App {


  val past = 2 days ago
  val appointment = 5 days from_now

  println(s"past: $past")
  println(s"appointment: $appointment")
}
