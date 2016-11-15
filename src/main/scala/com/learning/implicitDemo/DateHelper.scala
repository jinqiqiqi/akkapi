package com.learning.implicitDemo

import java.util.{Calendar, Date}

/**
  * Created by kinch on 1/26/16.
  */

class DateHelper(number: Int) {
  def days(when: String): Date = {
    val date = Calendar.getInstance()
    when match {
      case "ago" => date.add(Calendar.DAY_OF_MONTH, -number)
      case "from_now" => date.add(Calendar.DAY_OF_MONTH, number)
      case _ =>
    }

    date.getTime()
  }
}

object DateHelper {
  val ago = "ago"
  val from_now = "from_now"

  implicit def convertInt2DateHelper(number: Int) = new DateHelper(number)
}