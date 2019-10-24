package com.knoldus.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext

/**
 * Routes is class which contain details of all routes to be used
 *
 * @param ex   is execution context
 */
class Routes(implicit ex: ExecutionContext) {

  val routes: Route =
    get {
      path("inventory") {
        complete("welcome to inventory")
      }
    }
}
