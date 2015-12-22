package com.testing.akkaActor

import akka.actor._

/**
  * Created by kinch on 12/20/15.
  */
object DeathWatchTest extends App{
  val system = ActorSystem("DeathWatchTest")
  val parentActor = system.actorOf(Props[ParentActor], name = "Parent")

  val kennyActor = system.actorSelection("/user/Parent/KennyActor")
  kennyActor ! PoisonPill

  Thread.sleep(5000)

  println("calling system.terminate")
  system.terminate

}

class KennyActor extends Actor {
  def receive = {
    case _ => println("KennyActor received a message.")
  }
}

class ParentActor extends Actor {
  val kennyActor = context.actorOf(Props[KennyActor], name = "KennyActor")
  context.watch(kennyActor)

  def receive = {
    case Terminated(kenny) => println("OMG, they killed Kenny")
    case _ => println("Parent received a message.")
  }
}
