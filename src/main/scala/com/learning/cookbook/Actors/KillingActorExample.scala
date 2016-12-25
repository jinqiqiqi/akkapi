package com.learning.cookbook.Actors

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by kinch on 1/20/16.
  */

class Number5 extends Actor {
  def receive = {
    case m => println(s"Number5 got message: $m")
  }
  override def preStart {
    println("Number5 is alive:: preStart")
  }

  override def postStop { println("Number5::postStop called.")}
  override def preRestart(reason: Throwable, message: Option[Any]) {
    println("Number5::preRestart called.")
  }
  override def postRestart(reason: Throwable) {
    println("Number5::postRestart called.")
  }


}

object KillingActorExample extends App {
  val system = ActorSystem("KillingActorSystem")
  val number5 = system.actorOf(Props[Number5], name = "Number5")

  number5 ! "hello"
//  number5 ! Kill
  system.terminate()

}


