package com.learning.cookbook.Actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.collection.mutable.{Map => mMap}

/**
 * Created by kinch on 12/4/15.
 */

sealed trait PerfectNumberMessage

case class WorkerMsg(lower: Int, upper: Int, candidate: Int, numberofpartitions: Int) extends PerfectNumberMessage
case class MasterMsg(candidate: Int, portions: List[Int]) extends PerfectNumberMessage

class MasterActor(startTime: Long, taskLen: Int, sys: ActorSystem) extends Actor {

  var taskLeft = taskLen
  def receive = {
    case MasterMsg(candidate, vlist) =>
      val vt = vlist.sum
      val endTime = System.nanoTime()
      val diff = (endTime - startTime) / 1000000000.0
      taskLeft = taskLeft - 1
      if (taskLeft <= 0) {
        println(s"total of $candidate = $vt, in $diff seconds.")
        sys.terminate()
      }

    //      sys.shutdown
    case _ => println("error in line 23")
  }
}

class WorkerActor(master: ActorRef) extends Actor {
  var resultMap: mMap[Int, List[Int]] = mMap()

  def sumOfFactorsInRange(lower: Int, upper: Int, number: Int): Int = {
    (0 /: (lower to upper)) { (sum, i) =>
      if (number % i == 0)
        sum + i
      else
        sum
    }
  }

  def receive = {
    case WorkerMsg(lower, upper, candidate, numberofpartitions) =>
      //      resultMap = resultMap + (candidate -> sumOfFactorsInRange(lower, upper, candidate) :: resultMap(candidate))

      val tmp: List[Int] = if (resultMap.size > 0 && resultMap.get(candidate) != None)
        resultMap(candidate)
      else {
        List()
      }

      resultMap(candidate) = sumOfFactorsInRange(lower, upper, candidate) :: tmp
      //      println(s"$candidate workermsg. $lower")
      if (resultMap(candidate).size == numberofpartitions) {
        master ! MasterMsg(candidate, resultMap(candidate))
        println(s"$candidate send to master")
      }
    case _ => println("Error was matched": Any)
  }
}

object HelloActor extends App {
  //  case class
  val startTime = System.nanoTime()
  val system = ActorSystem("HelloSystem")

  //  val t = List(6500000, 6400000, 3000000, 4000000, 2100000)

  val t = List(1674836470)

  val masterActor = system.actorOf(Props(new MasterActor(startTime, t.size, system)), name = "MasterActor")
  val workerActor = system.actorOf(Props(new WorkerActor(masterActor)), name = "WorkerActor")

  def isPerfectConcurrent(candidate: Int) = {
    val Range = 5000
    val numberOfPartitions = (candidate.toDouble / Range).ceil.toInt
    println(s"numberofpartitions = $numberOfPartitions")

    for (i <- 0 until numberOfPartitions) {
      val lower = i * Range + 1
      val upper = candidate min (i + 1) * Range
      workerActor ! WorkerMsg(lower, upper, candidate, numberOfPartitions)
    }
  }

  for (n <- t)
    isPerfectConcurrent(n)

  //  system.terminate 

}



