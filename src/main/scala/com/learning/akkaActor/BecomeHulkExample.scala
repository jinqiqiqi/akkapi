package com.learning.akkaActor


import akka.actor._

/**
  * Created by kinch on 1/21/16.
  */


case object BadGuysMakeMeAngry
case object TryToFindSolution
case object ActNormalMessage

class DavidBanner extends Actor {
//  import context._

  def angryState: Receive = {
    case ActNormalMessage =>
      println("Phew, I'm back to being David")
      context.become(normalState)
  }

  def normalState: Receive = {
    case TryToFindSolution =>
      println("Looking for solution to my problem ...")
    case BadGuysMakeMeAngry =>
      println("I'm getting angry ...")
      context.become(angryState)
  }

  def receive = {
    case BadGuysMakeMeAngry => context.become(angryState)
    case ActNormalMessage => context.become(normalState)
  }
}


object BecomeHulkExample extends App {
  val system = ActorSystem("BecomeHulkExample")
  val davidBanner = system.actorOf(Props[DavidBanner], name="DavidBanner")

  davidBanner ! ActNormalMessage
  davidBanner ! TryToFindSolution
  davidBanner ! BadGuysMakeMeAngry

  Thread.sleep(1000)

  davidBanner ! ActNormalMessage

  system.terminate

}


