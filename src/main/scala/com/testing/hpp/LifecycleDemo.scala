package com.testing.hpp

import akka.actor.Actor.Receive
import akka.actor.{Actor, Props, ActorSystem}

case object ForceRestart

class Kenny extends Actor {
  println("Entered the Kenny constructor")

  override def preStart  {
    println("kenny: preStart")
  }

  override def postStop: Unit = {
    println("kenny: postStop")
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("kenny: preRestart")
    println(s" == MESSAGE: ${message.getOrElse(" > no message")}")
    println(s" == REASON: ${reason.getMessage}")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable): Unit = {
    println("kenny: postRestart")
    println(s" == REASON: ${reason.getMessage}")
    super.postRestart(reason)
  }

  def receive = {
    case ForceRestart => throw new Exception("Boom!")
    case otherMessage => println(s"Kenny received a message: ${otherMessage}")
  }
}

/**
  * Created by kinch on 12/19/15.
  */
object LifecycleDemo extends App {

  val system = ActorSystem("LifeCycleDemo")
  val kenny = system.actorOf(Props[Kenny], name="Kenny")

  println("Sending kenny a simple String message: ")
  kenny ! "hello"
  Thread.sleep(1000)

  println("Make kenny restart")
  kenny ! ForceRestart

  println("Stopping kenny")
  system.stop(kenny)

  println("Shutting down system")
  system.terminate


}
