// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/andre/Documents/meecarros/conf/routes
// @DATE:Thu Apr 26 10:32:27 BRT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.api.v1 {

  // @LINE:5
  class ReverseCarsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/v1/cars/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:6
    def show(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/cars/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:7
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/cars")
    }
  
    // @LINE:8
    def update(id:Long): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "api/v1/cars/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/cars")
    }
  
  }


}
