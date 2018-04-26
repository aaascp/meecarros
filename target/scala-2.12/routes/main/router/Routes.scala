// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/andre/Documents/meecarros/conf/routes
// @DATE:Thu Apr 26 10:32:27 BRT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  CarsController_1: controllers.api.v1.CarsController,
  // @LINE:13
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    CarsController_1: controllers.api.v1.CarsController,
    // @LINE:13
    Assets_0: controllers.Assets
  ) = this(errorHandler, CarsController_1, Assets_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, CarsController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars""", """controllers.api.v1.CarsController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars/""" + "$" + """id<[^/]+>""", """controllers.api.v1.CarsController.show(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars""", """controllers.api.v1.CarsController.create"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars/""" + "$" + """id<[^/]+>""", """controllers.api.v1.CarsController.update(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/cars/""" + "$" + """id<[^/]+>""", """controllers.api.v1.CarsController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_api_v1_CarsController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars")))
  )
  private[this] lazy val controllers_api_v1_CarsController_index0_invoker = createInvoker(
    CarsController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.v1.CarsController",
      "index",
      Nil,
      "GET",
      this.prefix + """api/v1/cars""",
      """ Cars Resource API v1""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_api_v1_CarsController_show1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_v1_CarsController_show1_invoker = createInvoker(
    CarsController_1.show(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.v1.CarsController",
      "show",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/v1/cars/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_api_v1_CarsController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars")))
  )
  private[this] lazy val controllers_api_v1_CarsController_create2_invoker = createInvoker(
    CarsController_1.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.v1.CarsController",
      "create",
      Nil,
      "POST",
      this.prefix + """api/v1/cars""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_api_v1_CarsController_update3_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_v1_CarsController_update3_invoker = createInvoker(
    CarsController_1.update(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.v1.CarsController",
      "update",
      Seq(classOf[Long]),
      "PATCH",
      this.prefix + """api/v1/cars/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_api_v1_CarsController_delete4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/cars/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_api_v1_CarsController_delete4_invoker = createInvoker(
    CarsController_1.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.api.v1.CarsController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """api/v1/cars/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_api_v1_CarsController_index0_route(params@_) =>
      call { 
        controllers_api_v1_CarsController_index0_invoker.call(CarsController_1.index)
      }
  
    // @LINE:6
    case controllers_api_v1_CarsController_show1_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_api_v1_CarsController_show1_invoker.call(CarsController_1.show(id))
      }
  
    // @LINE:7
    case controllers_api_v1_CarsController_create2_route(params@_) =>
      call { 
        controllers_api_v1_CarsController_create2_invoker.call(CarsController_1.create)
      }
  
    // @LINE:8
    case controllers_api_v1_CarsController_update3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_api_v1_CarsController_update3_invoker.call(CarsController_1.update(id))
      }
  
    // @LINE:9
    case controllers_api_v1_CarsController_delete4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_api_v1_CarsController_delete4_invoker.call(CarsController_1.delete(id))
      }
  
    // @LINE:13
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
