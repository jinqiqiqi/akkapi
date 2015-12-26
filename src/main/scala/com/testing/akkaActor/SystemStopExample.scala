package com.testing.akkaActor
import akka.actor._
import scala.language.postfixOps


/**
  * Created by kinch on 12/20/15.
  */
class TestActor extends Actor {
  def receive = {
    case "hello" => println("hello")
    case s => println(s)
  }
}

object SystemStopExample extends App{
  val system = ActorSystem("SystemStopExample")
  val actor = system.actorOf(Props[TestActor], name= "com/testing/test")

  actor ! Kill

}
