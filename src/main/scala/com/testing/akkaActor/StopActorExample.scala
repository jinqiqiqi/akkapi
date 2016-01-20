package com.testing.akkaActor

import akka.actor._
import akka.pattern.gracefulStop
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by kinch on 1/20/16.
  */
object StopActorExample extends App {
  val system = ActorSystem("SystemStopExample")
  val actor = system.actorOf(Props[TestActor], name = "test_stop")

  try {
    println("Start to stop....")
    val stopped: Future[Boolean] = gracefulStop(actor, 1 seconds)
    Await.result(stopped, 3 seconds)
    println("testActor was stopped.")
  }
  catch {
    case e: Exception => e.printStackTrace()
  }
  finally {
    system.terminate()
  }
//  actor ! "Before PoisonPill"
//
//  actor ! PoisonPill
//
//  actor ! "Hello"
//
//  system.stop(actor)
//
//  system.terminate()
}
