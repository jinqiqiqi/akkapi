package com.testing.collection

/**
  * Created by kinch on 1/26/16.
  */
object UsingSetExample extends App {
  val colors1 = Set("Blue", "Green", "Red")
  var colors = colors1
  println("colors1 (colors): "+ colors)

  colors += "Black"
  println("colors (colors): "+ colors)
  println("colors1 (colors): "+ colors1)

  val feeds1 = Set("blog.toolshed.com", "pragdave.pragprog.com", "pragmactic-osxer.blogspot.com", "vita-contemplativa.blogspot.com")
  val feeds2 = Set("blog.toolshed.com", "martinfowler.com/bliki")

  val blogSpotFeeds = feeds1 filter (_ contains "blogspot")
  println("blogspot feeds: "+ blogSpotFeeds.mkString(", "))

  val mergedFeeds = feeds1 ++ feeds2
  println(s"# of merged feeds: ${mergedFeeds.size}, ${mergedFeeds.mkString(", ")}")

  val commonFeeds = feeds1.intersect(feeds2)
  println(s"common feeds: ${commonFeeds.mkString(",")}")

  val urls = feeds1.map("http://" + _)
  println(s"=] feeds urls: ${urls.mkString(", ")}")

  urls.foreach{feed =>
    println(s"==] Refreshing $feed")
  }
}
