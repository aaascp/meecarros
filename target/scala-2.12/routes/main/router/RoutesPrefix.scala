// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/andre/Documents/meecarros/conf/routes
// @DATE:Thu Apr 26 10:32:27 BRT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
