package com.testing.akkaActor

import akka.actor.Status.Success

import scala.concurrent.{Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Random}

/**
  * Created by kinch on 1/20/16.
  */
object MultipleCalcsExample extends App {

  println("Starting futures")
  val r1 = runAlgrithm(1, "a")
  val r2 = runAlgrithm(2, "b")
  val r3 = runAlgrithm(3, "c")

  println("Before for-comprehension")
  val result: Future[Long] = for {
    result1 <- r1
    result2 <- r2
    result3 <- r3
  } yield (result1 + result2 + result3)

  println("Before onSuccess")

  result.onComplete{
    case result => println(s"Result: $result")
//    case Success(F) => println(s"Total is: ${F}")
  }


  println("Before sleep at the end")
  Thread.sleep(3000)



  def runAlgrithm(i: Int, n: String): Future[Int] = Future {
    val v = Random.nextInt(500)
    Thread.sleep(v)
    println(s"Value[${n}] is : ${v+i}")
    v + i

  }

}
