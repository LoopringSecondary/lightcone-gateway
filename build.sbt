import sbt._
import Dependencies._

lazy val basicSettings: Seq[Setting[_]] = Seq(
  name := "lightcone-gateway",
  scalaVersion := "2.12.6",
  organization := "org.loopring",
  organizationName := "Loopring Foundation",
  homepage := Some(url("https://loopring.org")),
  developers := List(
    Developer(
      id = "foundation@loopring.org",
      name = "Loopring Developers",
      email = "foundation@loopring.org",
      url = url("https://loopring.org"))),
  autoScalaLibrary := false,
  resolvers += "mvnrepository" at "http://mvnrepository.com/artifact/",
  resolvers += "ethereumlibrepository" at "https://dl.bintray.com/ethereum/maven/",
  resolvers += "JFrog" at "https://oss.jfrog.org/libs-release/",
  resolvers += "bintray" at "https://dl.bintray.com/ethereum/maven/",
  resolvers += Resolver.bintrayRepo("hseeberger", "maven"),
  resolvers += Opts.resolver.sonatypeSnapshots,
  resolvers += Opts.resolver.sonatypeReleases,
  libraryDependencies ++= Seq(
    "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"),
  javacOptions := Seq( //"-source", Globals.jvmVersion,
  ),
  scalacOptions := Seq(
    "-encoding", "utf8",
    "-g:vars",
    "-unchecked",
    "-deprecation",
    "-Yresolve-term-conflict:package"),
  fork in Test := false,
  parallelExecution in Test := false,
  startYear := Some(2018),
  licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")),
  shellPrompt in ThisBuild := { state => "sbt (%s)> ".format(Project.extract(state).currentProject.id) },
  publishArtifact in(Compile, packageSrc) := false,
  publishArtifact in(Compile, packageDoc) := true,
  publishTo := Some(
    if (isSnapshot.value) Opts.resolver.sonatypeSnapshots
    else Opts.resolver.sonatypeStaging),
  releaseCrossBuild := false)


lazy val gateway = (project in file("."))
  .enablePlugins(AutomateHeaderPlugin)
  .enablePlugins(JavaAppPackaging)
  .settings(
    PB.targets in Compile := Seq(
      scalapb.gen(flatPackage = false) -> (sourceManaged in Compile).value),

    basicSettings,

    libraryDependencies ++= testDependency ++ commonDependency ++ akkaDenepdency,
    libraryDependencies ++= socketIODenepdency ++ driverDenepdency

  )
