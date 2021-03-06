package com.learning.cookbook.Tests

import akka.actor.{Actor, Props, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.actor.actorRef2Scala
/**
  * Created by kinch on 12/20/15.
  */

case class AskNameMessage(name: String)

class AskActor extends Actor {
  def receive = {
    case AskNameMessage(name) => sender ! name
    case n => println(s"Requested name is ${n}")
  }
}
object AskExample extends App{
  val system = ActorSystem("AskExample")
  val askActor = system.actorOf(Props[AskActor], name="askActor")

  implicit val timeout = Timeout(01 seconds)

  val future = askActor ? AskNameMessage("Fred")
  askActor ! "Kinch"

  val result = Await.result(future, timeout.duration)
  println(s"R: ${result}")


}
