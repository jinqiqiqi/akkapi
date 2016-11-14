package com.learning.gui

import scala.swing._

/**
  * Created by kinch on 11/14/16.
  */
object FirstSwingApp extends SimpleSwingApplication {
  def top = new MainFrame {
    title ="第一个窗口，来自swing"
    contents = new Button {
      text = "点击试试"
    }
  }
}
