package com.learning.test

object Sort extends App {
  val votes = Seq(("scala", 1), ("java", 4), ("scala", 10), ("scala", 1), ("pyhton", 10), ("php", 25))

  val orderedVotes = votes
    .groupBy(_._1)
    .map { case (which, counts) =>
      (which, counts.foldLeft(0)(_ + _._2))
  }.toSeq
    .sortBy(_._2)
    .reverse


  val vbl = votes groupBy { case(lang, _)  => lang }
  val sbl = vbl map { case (lang, counts) =>
    val countsOnly = counts map { case (_, count) => count }
    (lang, countsOnly.sum)
  }
  val o2 = sbl.toSeq
    .sortBy { case (_, count) => count }
    .reverse

  println("++++++++")
  println(o2)
  println("++++++++")

  println(orderedVotes)
}
