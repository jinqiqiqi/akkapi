package com.learning.akkaActor

import akka.actor.{ActorRef, Props, Actor, ActorSystem}

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong: ActorRef) extends Actor {
  var count = 0
  def incrementAndPrint = {

    count += 1
    println(">>>ping: %d".format(count))
  }


  def receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage
    case PongMessage =>
      incrementAndPrint
      if(count > 100000) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      }
      else {
        sender ! PingMessage
      }
  }
}

class Pong extends Actor {
  var cnt = 0;

  def incrementAndPrint = cnt += 1

  def receive = {
    case PingMessage =>
      incrementAndPrint
      println("<<< pong %d".format(cnt))
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
//      context.system.terminate
  }
}

/**
  * Created by kinch on 12/4/15.
  */
object PingPongTest extends App{
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")

  ping ! StartMessage

}
