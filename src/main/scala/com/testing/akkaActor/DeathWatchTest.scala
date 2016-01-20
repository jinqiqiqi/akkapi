package com.testing.akkaActor

import akka.actor._

/**
  * Created by kinch on 12/20/15.
  */
object DeathWatchTest extends App{
  val system = ActorSystem("DeathWatchTest")
  val parentActor = system.actorOf(Props[ParentActor], name = "Parent")

  val kennyActor = system.actorSelection("/user/Parent/KennyActor")
  kennyActor ! Explode

  Thread.sleep(5000)

  kennyActor ! "hihi"
  kennyActor ! PoisonPill

//  println("calling system.terminate")
//  system.terminate

}

case object Explode

class KennyActor extends Actor {
  def receive = {
    case Explode => throw new Exception("Boom!")
    case _ => println("KennyActor received a message.")
  }
  override def preStart { println("Kenny: preStart")}
  override def postStop { println("Kenny: postStop")}
  override def preRestart(reason: Throwable, message: Option[Any]) {
    println("Kenny: preRestart")
    super.preRestart(reason, message)
  }
  override def postRestart(reason: Throwable) {
    println("Kenny: preStart")
    super.postRestart(reason)
  }
}

class ParentActor extends Actor {
  val kennyActor = context.actorOf(Props[KennyActor], name = "KennyActor")
  context.watch(kennyActor)

  def receive = {
    case Terminated(actorName) => println(s"OMG, they killed Kenny: $actorName")
    case _ => println("Parent received a message.")
  }
}
