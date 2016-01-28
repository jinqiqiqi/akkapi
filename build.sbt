name := "sbt_scala"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "Typesafe Repository" at
  "http://repo.typesafe.com/typesafe/releases/"

val akkaVersion = "2.4.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion
)

sublimeProjectDir := new java.io.File("/home/kinch/Public/sbt_scala/")


mainClass in(Compile, run) := Some("com.testing.matchDemo.TradeProcessor")
