package com.learning.test

/**
  * Created by kinch on 12/22/15.
  */

trait Service {
  def doAction(): Unit
}
trait BeforeServiceAspect extends Service {
  abstract override def doAction(): Unit = {
    println("Before doAction ...")
    super.doAction()
  }
}

trait AfterServiceAspect extends Service {
  abstract override def doAction(): Unit = {
    super.doAction()
    println("After doAction ...")
  }
}

class ServiceImpl extends Service {
  def doAction = {
    println("do job")
  }
}
object ServiceImpl extends App {
  val s = new ServiceImpl with AfterServiceAspect with BeforeServiceAspect
    s.doAction()
}
