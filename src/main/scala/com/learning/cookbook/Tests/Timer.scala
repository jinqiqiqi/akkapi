package com.learning.cookbook.Tests

/**
  * Created by kinch on 12/22/15.
  */
object Timer extends App{

  def oncePerSecond(callback: () => Unit) = {
    while(true) {
      callback()
      Thread.sleep(1000)
    }
  }

  oncePerSecond(() =>{
      val ct = System.currentTimeMillis
      println(s"Time files... ho, you get the idea. $ct")
    }
  )



}
