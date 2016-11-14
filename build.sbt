name := "HelloScala"

version := "1.0"

scalaVersion := "2.10.4"

ensimeScalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at
  "http://repo.typesafe.com/typesafe/releases/"

val akkaVersion = "2.4.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion
)

libraryDependencies ++= Seq (
    "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
)

sublimeProjectDir := new java.io.File("/home/kinch/Public/sbt_scala/")


mainClass in(Compile, run) := Some("com.testing.matchDemo.TradeProcessor")
