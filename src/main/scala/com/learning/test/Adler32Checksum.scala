package com.learning.test

/**
  * Created by kinch on 12/6/15.
  */
object Adler32Checksum {
  val MOD_ADLER = 65521

  def main(args: Array[String]) {
    val values = List(1,2,3,4,5)
    for(i <- values) println(matchs(i))
//    println(matchs(1))

//    val sum = adler32sum("Wikipedia")
//    printf("Checksum (int) = %d\n", sum)
//    printf("Checksum (hex) = %s\n", sum.toHexString)
  }

  def matchs(i: Int): String = {
    i match {
      case 1 => "case 1"
      case 2 => "case 2"
      case someElse => "get the: "+ someElse
    }
  }

  def adler32sum(s: String): Int = {
    var a = 1
    var b = 0
    s.getBytes.foreach{ char =>
      a = (char + a) % MOD_ADLER
      b = b + a
    }

    b * 65536 + a
  }
}
