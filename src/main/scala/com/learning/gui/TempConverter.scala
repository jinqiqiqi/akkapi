package com.learning.gui

import scala.swing.event.EditDone
import scala.swing._

/**
  * Created by kinch on 11/15/16.
  */
object TempConverter extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Celsius/Fahrenheit Converter"

    object celsius extends TextField { columns = 5 }
    object fahrenheit extends TextField { columns = 5 }

    contents = new FlowPanel {
      contents += celsius
      contents += new Label(" Celsius = ")
      contents += fahrenheit
      contents += new Label(" Fahrenheit ")
      border = Swing.EmptyBorder(15, 10, 10, 10)
    }

    listenTo(celsius, fahrenheit)
    reactions += {
      case EditDone(`fahrenheit`) =>
        val f = fahrenheit.text.trim match {
          case "" => 0
          case x => x.toInt
        }
        val c = (f - 32) * 5 / 9
        celsius.text = c.toString

      case EditDone(`celsius`) =>
        val c = celsius.text.trim match {
          case "" => 0
          case x => x.toInt
        }
        val f = c * 9 / 5 + 32
        fahrenheit.text = f.toString
    }
  }
}
