package com.learning.cookbook.Tests

/**
  * Created by kinch on 1/12/16.
  */
object CSVReader extends App{
  val nrows = 3
  val ncols = 4
  val rows = Array.ofDim[String](nrows, ncols)

  val bufferedSource = io.Source.fromFile("t.csv")
  var count = 0

  for (line <- bufferedSource.getLines()) {
    rows(count) = line.split(",").map(_.trim)
    count += 1
  }
  bufferedSource.close()

  for (i <- 0 until nrows)
    println(s"${rows(i)(0)} = ${rows(i)(1)} = ${rows(i)(2)} = ${rows(i)(3)}")

  println(rows)
}
