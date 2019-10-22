import Dependencies._
import CommonSettings._
import scoverage.ScoverageKeys

name := "Assignment"

version := "1.0"

scalaVersion := scala
//mainClass in (Compile, packageBin) := Some("com.knoldus.inventoryservice.InventoryImpl")

lazy val root = (
  project.in(file(".")).settings(mainClass in (Compile, packageBin) := Some("com/knoldus/inventoryservice/InventoryImpl") , mainClass in (Compile, run) := Some("com.knoldus.inventoryservice.InventoryImpl")
,
    run := {
      (run in inventory in Compile).evaluated
    }).aggregate(inventory)
  )
lazy val inventory = (
  baseProject("inventory")
    settings(test in assembly := {}, strategy, libraryDependencies ++= compileDeps(inventoryDependencies) ++ testDeps(h2, scalaTest, mock, slickTest2, slickTest3, slickTest4),
    ScoverageKeys.coverageMinimum := 90,
    ScoverageKeys.coverageFailOnMinimum := true,
    ScoverageKeys.coverageExcludedPackages := "",
    ScoverageKeys.coverageEnabled := true
  ))

def compileDeps(deps: Seq[ModuleID]): Seq[ModuleID] = deps map (_ % "compile")

def testDeps(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")
val strategy = assemblyMergeStrategy in assembly := {
  case "META-INF/versions/9/module-info.class" => MergeStrategy.discard
  case PathList("org",   "apache", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case "javax/inject/Inject.class" => MergeStrategy.last
  case "javax/inject/Named.class" => MergeStrategy.last
  case "javax/inject/Provider.class" => MergeStrategy.last
  case "javax/inject/Qualifier.class" => MergeStrategy.last
  case "javax/inject/Scope.class" => MergeStrategy.last
  case "javax/inject/Singleton.class" => MergeStrategy.last
  case "org/aopalliance/aop/Advice.class" => MergeStrategy.last
  case "org/aopalliance/aop/AspectException.class" => MergeStrategy.last
  case "org/aopalliance/intercept/ConstructorInterceptor.class" => MergeStrategy.last
  case "org/aopalliance/intercept/ConstructorInvocation.class" => MergeStrategy.last
  case "org/aopalliance/intercept/Interceptor.class" => MergeStrategy.last
  case "org/aopalliance/intercept/Invocation.class" => MergeStrategy.last
  case "org/aopalliance/intercept/Joinpoint.class" => MergeStrategy.last
  case "org/aopalliance/intercept/MethodInterceptor.class" => MergeStrategy.last
  case "org/aopalliance/intercept/MethodInvocation.class" => MergeStrategy.last
  case "org/slf4j/impl/StaticLoggerBinder.class" => MergeStrategy.last
  case "org/slf4j/impl/StaticMDCBinder.class" => MergeStrategy.last
  case "org/slf4j/impl/StaticMarkerBinder.class" => MergeStrategy.last
  case "git.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

