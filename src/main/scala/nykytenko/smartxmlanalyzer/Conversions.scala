package nykytenko.smartxmlanalyzer

import scala.xml.Node

object Conversions {

  implicit class ConvertSeqToString(seq: Seq[String]) {
    def toShow: String = if (seq.nonEmpty) seq.mkString(" > ") else "pattern not found"
  }

  implicit class ConvertNodeToString(node: Node) {
    def toShow: String = {
      val description = node.attribute("class") match {
        case Some(seq) => s" class='$seq'"
        case None      => ""
      }
      s"${node.label}$description"}
  }
}
