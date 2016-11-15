package com.testing.collection

/**
  * Created by kinch on 1/26/16.
  */
object UsingMapExample extends App {
  val feeds = Map("Andy Hunt" -> "blog.toolshed.com",
    "Dave Thomas" -> "pragdave.pragprog.com",
    "Dan Steinberg" -> "dimsumthinking.com/blog"
  )

  val filterNameStartWithD = feeds.filterKeys(_ startsWith("D"))
  println(s"=] filterNameStartWithD: ${filterNameStartWithD}")


  val filterNameStartWithDAndBlogIn = feeds.filter { elem =>
    val (key, value) = elem
    key.startsWith("D") && value.contains("blog")
  }
  println(s"==] filterNameStartWithDAndBlogIn: ${filterNameStartWithDAndBlogIn}")

  println(s"=] GET Andy's Feed: "+ feeds.get("Andy Hunt"))
  println(s"=] GET Andy's Feed: "+ feeds.get("Eric King"))


  try {
    println(s"==] get Andy's Feed using apply(): ${feeds("Andy Hunt")}")
    println(s"==] get Andy's Feed using apply(): ${feeds("Eric King")}")
  }
  catch {
    case e: java.util.NoSuchElementException => println("Not found")
  }

  val newFeed1 = feeds.updated("Venkat Subramaniam", "agiledeveloper.com/blog")
  println(newFeed1)

  val prefixdList = "forums.pragprog.com/forums/87" :: feeds.toList
  println("==] prepended feed: "+ prefixdList)
}
