package com.testing.hpp

import akka.actor._

/**
  * Created by kinch on 12/19/15.
  */
object ParentChildDemo extends App{
  val system = ActorSystem("ParentChildDemo")
  val parent = system.actorOf(Props[Parent], name = "Parent")

  parent ! CreateChild("Jonathan")
  parent ! CreateChild("Jordan")
  Thread.sleep(500)

  println("Sending Jonathan a PoisonPill ...")
  val jonathan = system.actorSelection("/user/Parent/Jonathan")
  jonathan ! PoisonPill
  println("Jonathan was killed.")


  Thread.sleep(500)
  system.terminate


}


case class CreateChild(name: String)
case class Name(name: String)

class Parent extends Actor {
  def receive = {
    case CreateChild(name) =>
      println(s"Parent about to create Child ($name)")
      val child = context.actorOf(Props[Child], name=s"$name")
      child ! Name(name)
    case _ => println(s"Parent got some other message")
  }
}

class Child extends Actor {
  var name = "No name"

  override def postStop: Unit = {
    println(s"D'ho! They killed me ($name): ${self.path}")
  }

  def receive = {
    case Name(name) => this.name = name
    case _ => println(s"Child $name got message")
  }
}
