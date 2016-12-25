package com.learning.cookbook.Actors

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by kinch on 1/21/16.
  */

case object AskNameMessage

class AskActor extends Actor {
  def receive = {
    case AskNameMessage =>
      sender ! "Fred"
    case _ => println("Unexpected message")
  }
}

object AskActorExample extends App {
  val system = ActorSystem("AskActorSystem")
  val askActor = system.actorOf(Props[AskActor], name="askActor")

  implicit val timeout = Timeout( 5 seconds )
  val future =  askActor ? AskNameMessage

  val result = Await.result(future, timeout.duration).asInstanceOf[String]
  println(s"Result 1: $result")

  val future2 = ask(askActor, AskNameMessage).mapTo[String]
  val result2 = Await.result(future2, 1 second)
  println(s"Result 2: $result2")



  system.terminate

}


