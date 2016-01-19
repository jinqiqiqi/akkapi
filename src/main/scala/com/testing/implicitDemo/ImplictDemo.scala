package com.testing.implicitDemo


 /**
  * Created by kinch on 12/22/15.
  */

object Context {
	implicit val ccc: String = "implicitx"
}

object Param {
	def print(content: String)(implicit prefix: String): Unit = {
		println(prefix + ": " + content)
	}
}

object ImplictDemo extends App{
	Param.print("jack")("hello")

	import Context._
	Param.print("jacks")


}
