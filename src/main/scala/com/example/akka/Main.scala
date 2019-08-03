package com.example.akka

import com.example.akka.http.WebServer
import kamon.Kamon

object Main extends App {
  Kamon.init()
  WebServer.start()
}
