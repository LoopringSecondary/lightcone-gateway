import sbt._

object Dependencies {

  lazy val slf4jVersion = "1.7.25"
  lazy val logbackVersion = "1.2.3"
  lazy val json4sVersion = "3.5.4"
  lazy val akkaVersion = "2.5.14"
  lazy val akkaHttpVersion = "10.1.3"
  lazy val slickVersion = "3.2.3"

  lazy val testDependency = Seq(
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
    "org.scalatest" %% "scalatest" % "3.0.0",
    "org.scalamock" %% "scalamock" % "4.1.0",
    "io.socket" % "socket.io-client" % "1.0.0"
  ) map (_ % Test)

  lazy val commonDependency = Seq(

    "com.github.scopt" %% "scopt" % "3.7.0",
    "com.google.inject" % "guice" % "4.2.1",
    "net.codingwell" %% "scala-guice" % "4.2.1",

    "org.slf4j" % "slf4j-api" % slf4jVersion,
    "ch.qos.logback" % "logback-core" % logbackVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion,

    "org.json4s" %% "json4s-native" % json4sVersion,
    "org.json4s" %% "json4s-jackson" % json4sVersion,
    "org.json4s" %% "json4s-ext" % json4sVersion,

    "com.thesamet.scalapb" %% "scalapb-json4s" % "0.7.0",
    "de.heikoseeberger" %% "akka-http-json4s" % "1.21.0",
    "com.github.nscala-time" %% "nscala-time" % "2.20.0"
  )

  lazy val akkaDenepdency = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-contrib" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion)

  lazy val socketIODenepdency = Seq(

    // "org.reflections" % "reflections" % "0.9.11",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.7",
    "com.corundumstudio.socketio" % "netty-socketio" % "1.7.16"
  )

  lazy val driverDenepdency = Seq(
    "com.github.etaty" %% "rediscala" % "1.8.0",
    "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "0.20",
    "mysql" % "mysql-connector-java" % "5.1.47"
  )
}