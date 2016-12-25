package com.learning.cookbook.Actors

import akka.actor._

import scala.language.postfixOps


/**
  * Created by kinch on 12/20/15.
  */
class TestActor extends Actor {
  def receive = {
    case "hello" => println("hello")
    case s: String => println(s)
    case _ => println("Unknow message sent to TestActor")
  }

  override def postStop = println("TestActor::postStop called.")
}

object SystemStopExample extends App{
  val system = ActorSystem("SystemStopExample")
  val actor = system.actorOf(Props[TestActor], name= "com/learning/test")

  actor ! Kill

}
