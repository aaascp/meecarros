// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/andre/Documents/meecarros/conf/routes
// @DATE:Thu Apr 26 10:32:27 BRT 2018

package controllers.api.v1;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.api.v1.ReverseCarsController CarsController = new controllers.api.v1.ReverseCarsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.api.v1.javascript.ReverseCarsController CarsController = new controllers.api.v1.javascript.ReverseCarsController(RoutesPrefix.byNamePrefix());
  }

}
