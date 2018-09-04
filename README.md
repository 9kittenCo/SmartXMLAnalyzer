**Smart XML Analyzer**

Program that analyzes HTML and finds a specific element, even after changes, using a set of extracted attributes.
Full description on: 
https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/

*For use needed to run:*
1. `sbt compile`
2. `sbt assembly`

*For testing as example:*

```
java -jar target/scala-2.12/SmartXMLAnalyzer-2.12.6-0.1.jar "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-0-origin.html" "eveververv" "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/samples/sample-2-container-and-clone.html" "https://agileengine.bitbucket.io/beKIvpUlPMtzhfAy/" 
```