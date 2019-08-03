name := "kamon-akka-sample"

scalaVersion := "2.12.8"

resolvers += Resolver.bintrayRepo("kamon-io", "releases")

val akkaVersion = "2.5.23"
val akkaHttpVersion = "10.1.9"
val kamonVersion = "2.0.0"

libraryDependencies ++= Seq(
  "io.kamon" %% "kamon-akka-http" % kamonVersion,
  "io.kamon" %% "kamon-akka" % kamonVersion,
  "io.kamon" %% "kamon-prometheus" % kamonVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
