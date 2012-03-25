import org.mortbay.jetty.nio.SelectChannelConnector
import org.mortbay.jetty.webapp.WebAppContext
import org.mortbay.jetty.{Connector, Server}

/**
 *
 * User: Lim, Teck Hooi
 * Date: 24/3/12
 * Time: 3:38 PM
 *
 */

object Start {
  def main(args: Array[String]) {
    var server = new Server
    var connector = new SelectChannelConnector
    connector.setPort(8080)
    server.setConnectors(Array[Connector](connector))

    var web = new WebAppContext
    web.setContextPath("/")
    web.setWar("src/main/webapp")
    web.setExtraClasspath(".")
    server.addHandler(web)

    try
    {
      server.start
      server.join
    }
    catch
      {
        case e: Exception =>
        {
          e.printStackTrace
          System.exit(100)
        }
      }
  }
}