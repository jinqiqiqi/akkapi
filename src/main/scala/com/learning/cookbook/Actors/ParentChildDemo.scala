package com.learning.cookbook.Actors

import akka.actor._


case class CreateChild(name: String)
case class Name(name: String)

class Parent extends Actor {
  def receive = {
    case CreateChild(name) =>
      println(s"Parent about to create Child ($name)")
      val child = context.actorOf(Props[Child], name=s"$name")
      child ! Name(name)
      child ! "hi"
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
    case msg => println(s"Child $name got message: $msg")
  }
}


/*
  * Created by kinch on 12/19/15.
  */
object ParentChildDemo extends App{
  val system = ActorSystem("ParentChildDemo")
  val parent = system.actorOf(Props[Parent], name = "Parent")

  parent ! CreateChild("Jonathan")
  parent ! CreateChild("Jordan")
  println("Start to sleep 3 seconds")
  Thread.sleep(3000)
  
  println()
  println("Sending Jonathan a PoisonPill ...")
  val jonathan = system.actorSelection("/user/Parent/Jonathan")
  jonathan ! PoisonPill
  println("Jonathan was killed.")


  Thread.sleep(500)
  system.terminate


}

