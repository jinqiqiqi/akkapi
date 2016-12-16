package com.learning.akkaActor

import akka.actor.Actor



object Greeter {
  case object Greet
  case object SayHi
  case object Done
}

class Greeter extends Actor {
  def receive = {
    case Greeter.Greet =>
      println("Hello world! "+ Greeter.Done)
    case Greeter.SayHi =>
      println("You said hi to me?")
      sender() ! Greeter.Done
  }
}
