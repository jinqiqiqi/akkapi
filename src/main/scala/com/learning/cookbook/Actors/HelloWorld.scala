package com.learning.akkaActor

import akka.actor.{ Actor, ActorSystem, Props }

// import akka.actor.{ Actor, ActorSystem, Props }

/**
 * Created by kinch on 12/4/15.
 */
object HelloWorld extends App {
  val system = ActorSystem("HelloWorld")
  val hello = system.actorOf(Props(new Hello(system)), "hello_actor")
  hello ! Greeter.SayHi

}

class Hello(sys: ActorSystem) extends Actor {
  override def preStart(): Unit = {
    val greeter = context.actorOf(Props[Greeter], "greeter")
    greeter ! Greeter.Greet

  }

  def receive = {
    case Greeter.Done =>
      println("stop???")
      sys.terminate()
    case msg =>
      println(s"nono $msg")

  }
}


