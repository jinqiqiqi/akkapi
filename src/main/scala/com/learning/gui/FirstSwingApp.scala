package com.learning.gui


import scala.swing._
import scala.swing.event.{ButtonClicked}

/**
  * Created by kinch on 11/14/16.
  */
object FirstSwingApp extends SimpleSwingApplication {
    def top = new MainFrame {
      title ="第一个窗口，来自swing"
      val button = new Button {
        text = "Click me"
      }
      val label = new Label {
        text = "No button clicks registered"
      }
      contents = new BoxPanel(Orientation.Vertical) {
        contents += button
        contents += label
        border = Swing.EmptyBorder(30, 30, 30, 30)
      }
      listenTo(button)
      var nClicks = 0
      reactions += {
        case ButtonClicked(b) =>
          nClicks += 1
          label.text = "Click: "+ nClicks
      }
    }

}
