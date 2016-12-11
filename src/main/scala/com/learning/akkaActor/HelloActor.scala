package com.learning.akkaActor

import scala.Predef
import akka.actor.{Props, ActorSystem, Actor}

/**
  * Created by kinch on 12/4/15.
  */
class HelloActor(myName: String) extends Actor{

  def receive = {
    case "hello" => println("hello from: %s".format(myName))
    case f => println("huh? said %s".format(myName))
      println(s"$f")
  }
}


object Main extends App {
  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props(new HelloActor("Kinch")), name = "helloactor")

  helloActor ! "hello"
  helloActor ! "Buenos dias"
  
  helloActor ! "yes"

//  system.terminate
  
}
