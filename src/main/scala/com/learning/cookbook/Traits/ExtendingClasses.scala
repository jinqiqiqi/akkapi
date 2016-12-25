//
//// extending classes
//package com.learning.cookbook.Traits
//
//abstract class Connector {
//    def connect()
//    def close()
//}
//
//trait ConnectorWithHelper extends Connector {
//    def findDriver(): Unit = {
//        println("Find driver called.")
//    }
//}
//
//class PgSqlConnector extends ConnectorWithHelper {
//    override def connect(): Unit = {
//        println("Connected...")
//    }
//
//    override def close(): Unit = {
//        println("Closed...")
//    }
//}
//
//
//// Extending traits
//trait Ping {
//    def ping(): Unit = {
//        println("ping")
//    }
//}
//
//trait Pong {
//    def pong(): Unit = {
//        println("pong")
//    }
//}
//
//trait PingPong extends Ping with Pong {
//    def pingPong(): Unit = {
//        ping()
//        pong()
//    }
//}
//
//object Runner extends PingPong {
//  def main(args: Array[String]): Unit = {
//    pingPong()
//  }
//}
//
///*
//Extending traits is useful in a design pattern called stackable traits.
// */
//
//// Mixin compositions
//object MixinRunner extends Ping with Pong {
//  def main(args: Array[String]): Unit = {
//    ping()
//    pong()
//  }
//}
//
//
//// composing
//
//class Watch(brand: String, initialTime: Long) {
//  def getTime(): Long = System.currentTimeMillis() - initialTime
//}
//
//object WatchUser {
//  def main(args: Array[String]): Unit = {
//    val expensiveWatch = new Watch("expensive brand", 1000L) with Alarm with Notifier {
//      override def trigger(): String = "The alarm was triggeed."
//      override def clear(): Unit = println("Alarm cleared")
//      override def notificationMessage: String = "Alarm is running"
//      val cheapWatch = new Watch("cheap brand", 10L) with Alarm {
//        
//      }
//    }
//  }
//}
//
//
//// linearization
//class Animal extends AnyRef
//
//class Dog extends Animal
//
//// Animal -> AnyRef -> Any
//// Dog -> Animal -> AnyRef -> Any
//
//// another sample
//// class A extends B with T1 with T2
//
//
////Method overriding
//class MultiplierIdentity {
//  def identity : Int = 1
//}
//
//trait DoubleMultiplierIdentity extends MultiplierIdentity {
//  override def identity: Int = 2 * super.identity
//}
//
//trait TrippleMultiplierIdentity extends MultiplierIdentity {
//  override def identity: Int = 3* super.identity
//}
//
//class ModifiedIdentity1 extends DoubleMultiplierIdentity with TrippleMultiplierIdentity
//
//class ModifiedIdentity2 extends DoubleMultiplierIdentity with TrippleMultiplierIdentity {
//  override def identity: Int = super[DoubleMultiplierIdentity].identity
//}
//
//class  ModifiedIdentity3 extends DoubleMultiplierIdentity with TrippleMultiplierIdentity {
//  override def identity: Int = super[TrippleMultiplierIdentity].identity
//}
//
//
//class ModifiedIdentity4 extends TrippleMultiplierIdentity with DoubleMultiplierIdentity
//
//class ModifiedIdentity5 extends TrippleMultiplierIdentity with DoubleMultiplierIdentity {
//  override def identity: Int = super[TrippleMultiplierIdentity].identity
//}
//
//object ModifiedIdentityUser {
//  def def main(args: Array[String]): Unit = {
//    val instance1 = new ModifiedIdentity1
//  }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
