package com.testing.akkaActor


import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure, Random}

/**
  * Created by kinch on 1/20/16.
  */
object FutureCallbackExample extends App {
  implicit val baseTime = System.currentTimeMillis()

  def longRunningComputation(i: Int): Future[Int] = Future {
    sleep(400)
    i + 1
  }
  println("Starting calculation ... ")

  longRunningComputation(11).onComplete{
    case Success(result) => println(s"result = $result")
    case Failure(e) => e.printStackTrace()
  }

  def sleep(i: Long) = Thread.sleep(i)

  val f = Future {
    val v = Random.nextInt(500)
    sleep(v)
//    if(v > 250) throw new Exception("TIMEOUT in FUTURE") else v
    v
  }

  println("Before onComplete ... ")
  f.onComplete{
    case Success(value) =>
      println(s"Got the callback, value: $value")
    case Failure(e) =>
      e.printStackTrace()
  }
  f.onFailure{
    case t => println(s"Exception: ${t.getMessage}")
  }


  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)
  println("G ..."); sleep(100)



  println("::END::")
}
