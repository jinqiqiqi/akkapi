package com.learning.cookbook.Actors

import java.util.concurrent.TimeoutException

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Created by kinch on 1/20/16.
  */
object FutureExample extends App {
//  implicit val baseTime = System.currentTimeMillis()

  def sleep(i: Long) = Thread.sleep(i)

  val f = Future {
    sleep(5000)
    1+1
  }

  try{
    val result = Await.result(f, 2 second)
    println(s"result: $result")
  }
  catch {
    case e: TimeoutException =>
      println("Timeout exception.")

    case e: Exception =>
      println("响应超时")
      e.printStackTrace()
  }

  sleep(1000)


  println("::END::")

}
