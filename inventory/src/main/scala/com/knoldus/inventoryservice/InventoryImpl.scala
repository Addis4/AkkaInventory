package com.knoldus.inventoryservice

import akka.http.scaladsl.Http
import akka.http.scaladsl.server._
import com.knoldus.connection.HttpConnection._
import com.knoldus.routes.Routes

object InventoryImpl extends App {

  lazy val routes: Route = new Routes().routes

  Http().bindAndHandle(routes, httpHost, httpPort)

}
