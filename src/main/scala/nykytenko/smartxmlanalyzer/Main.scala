package nykytenko.smartxmlanalyzer

object Main {

  def main(args: Array[String]): Unit = {

    val resultSeq = args.map(XMLAnalyzer.parse)

    resultSeq foreach println

  }
}
