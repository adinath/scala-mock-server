lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.fun",
      scalaVersion := "2.12.4"
    )),
    name := "nextgen-demo"
  )

libraryDependencies ++= Seq(
  "com.github.tomakehurst" % "wiremock-standalone" % "2.18.0"
)

