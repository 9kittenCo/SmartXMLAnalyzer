organization := "nykytenko"
name := "SmartXMLAnalyzer"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++=  Seq(
  "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2.1",
  "org.scala-lang.modules" %% "scala-xml" % "1.1.0"
)

//mainClass in assembly := Some("nykytenko.smartxmlanalyzer.Main")

assemblyJarName in assembly := s"${name.value}-${scalaVersion.value}-${version.value}.jar"