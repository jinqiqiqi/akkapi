package com.testing.collection

/**
  * Created by kinch on 12/21/15.
  */
object VectorExample extends App{
  val v = Vector("A", "B", "CC")
  println(v)

  val vb = v ++ Vector(1, 2, 3)
  println(vb)
}
