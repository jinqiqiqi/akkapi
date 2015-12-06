package test

/**
  * Created by kinch on 12/6/15.
  */
object Adler32Checksum {
  val MOD_ADLER = 65521

  def main(args: Array[String]) {
    val sum = adler32sum("Wikipedia")
    printf("Checksum (int) = %d\n", sum)
    printf("Checksum (hex) = %s\n", sum.toHexString)
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
