package com.learning.cookbook.Basics

object StockFinder {
  def getLatestClosingPrice(symbol: String) = {
    val url = "http://ichart.finance.yahoo.com/table.csv?s=GOOG&a=00&b=01&c=2015"

    val data = scala.io.Source.fromURL(url).mkString
    val mostRecentData = data.split("\n")(1)
    mostRecentData.split(",")(4).toDouble
  }

//  def getTickersAndUnits() = {
//    val stocksAndUnitsXML = scala.xml.XML.load("stocks.xml")
//      (Map[String, Int]() /: (stocksAndUnitsXML \"symbol")) {(xmap, symbolNode) =>
//      val ticker = (symbolNode \ "@ticker").toString()
//      val units = (symbolNode \ "units").text.toInt
//      //xmap(ticker) = units
//    }
//  }
}

object StockPriceFinder extends App {

}
