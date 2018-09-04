package nykytenko.smartxmlanalyzer

import java.net.{MalformedURLException, URL}

import scala.util.{Failure, Success, Try}
import scala.xml.Node

object XMLAnalyzer {

  import Conversions._

  def getURL(sourceName: String): Try[URL] = Try(new URL(sourceName))

  def isExist(node: Node): Boolean = (node \ "a").exists(_.attribute("href").getOrElse(Seq.empty[Node]).head.toString.contains("#ok"))

  def parse(sourceName: String): String = {
    getURL(sourceName) match {
      case Success(url)       => loop(HTMLParser.load(url), Seq.empty[String]).toShow
      case Failure(exception) => exception match {
        case e: MalformedURLException => s"Malformed URL Exception: ${e.getMessage}"
        case _: Throwable             => "Unexpected error"
      }
    }
  }

  def loop(node: Node, acc: Seq[String]): Seq[String] =
    if (isExist(node)) acc :+ node.toShow :+ "a"
    else node.nonEmptyChildren.flatMap(loop(_, acc :+ node.toShow)).filter(_.nonEmpty)
}
