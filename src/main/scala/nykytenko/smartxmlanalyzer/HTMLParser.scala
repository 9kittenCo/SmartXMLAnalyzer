package nykytenko.smartxmlanalyzer

import java.net.{HttpURLConnection, URL}

import javax.xml.parsers.SAXParser
import org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl
import org.xml.sax.InputSource
import scala.xml.Node
import scala.xml.parsing.NoBindingFactoryAdapter

object HTMLParser {
  lazy val adapter: NoBindingFactoryAdapter = new NoBindingFactoryAdapter
  lazy val parser: SAXParser                = (new SAXFactoryImpl).newSAXParser

  def load(url: URL, headers: Map[String, String] = Map.empty): Node = {
    val conn = url.openConnection().asInstanceOf[HttpURLConnection]
    for ((k, v) <- headers) conn.setRequestProperty(k, v)
    val source = new InputSource(conn.getInputStream)
    adapter.loadXML(source, parser)
  }
}
