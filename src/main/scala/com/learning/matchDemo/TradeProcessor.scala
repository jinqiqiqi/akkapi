package com.learning.matchDemo


abstract class Trade()

case class Sell(stockSymbol: String, quantity: Int) extends Trade
case class Buy(stockSymbol: String, quantity: Int) extends Trade
case class Hedge(stockSymbol: String, quantity: Int) extends Trade




object TradeProcessor extends App {
  
  processTransaction(Sell("GOOD", 500))


  def processTransaction(request: Trade) = {
    request match {
      case Sell(stock, 1000) => println(s"Selling 1000-units of $stock")
      case Sell(stock, quantity) => printf("Selling %d units of %s\n", quantity, stock)
      case Buy(stock, quantity) if (quantity > 2000) => printf("Buying %d (large) units of %s\n", quantity, stock)
      case Buy(stock, quantity) => printf("Buying %d units of %s\n", quantity, stock)
    }
    
  }
}

