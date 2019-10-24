package com.knoldus.testroute

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.stream.ActorMaterializer
import com.knoldus.routes.Routes
import org.scalatest.WordSpec

import scala.concurrent.ExecutionContextExecutor

class RoutesSpec extends WordSpec with ScalatestRouteTest {

  implicit lazy val testSystem: ActorSystem = ActorSystem()
  implicit lazy val testMaterializer: ActorMaterializer = ActorMaterializer()
  implicit val dispatcher: ExecutionContextExecutor = system.dispatcher
  val testRoutes: Route = new Routes().routes
  "/inventory route" should {
    "give list of items in inventory" in {
      Get("/inventory") ~> testRoutes ~> check {
        responseAs[String] === "welcome to inventory"
      }
    }
  }
}
