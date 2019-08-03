package com.example.akka.http

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{Directives, HttpApp}
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import org.slf4j.LoggerFactory

import scala.concurrent.duration.DurationInt

object WebServer extends HttpApp with Directives {
  val logger = LoggerFactory.getLogger(WebServer.getClass)
  implicit val system = ActorSystem("pingserver")
  val timeout = 10.seconds
  sys.addShutdownHook(system.terminate())

  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  override def routes = extractRequest { request =>
    logger.info(s"uri: ${request.uri}")
    logger.info(s"method: ${request.method.value}")
    logger.info(s"headers:\n${request.headers.map(_.toString).mkString("\n")}")
    Unmarshal(request.entity).to[String].map { requestText =>
      logger.info(s"message:\n$requestText")
    }
    complete("")
  }

  def start(): Unit = startServer("0.0.0.0", 12345)
}
