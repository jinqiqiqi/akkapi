name := "HelloScala"

version := "1.0"

scalaVersion := "2.11.7"

//ensimeScalaVersion := "2.11.7"

resolvers += "Typesafe Repository" at
  "http://repo.typesafe.com/typesafe/releases/"

val akkaVersion = "2.4.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion
)

libraryDependencies ++= Seq (
    "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
    "org.scala-lang" % "scala-swing" % "2.11+"
)

//sublimeProjectDir := new java.io.File("/home/kinch/Public/sbt_scala/")



mainClass in(Compile, run) := Some("com.learning.gui.FirstSwingApp")
