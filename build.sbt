
scalaVersion := "2.12.8"
name := "algoPlayground"
version := scala.util.Properties.envOrElse("VERSION", "snapshot")

val http4sVersion = "0.21.0"
val specs2Version = "4.8.3"
val circeVersion = "0.13.0"
val doobieVersion = "0.8.4"
val catsVersion = "2.1.1"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:higherKinds"
)

libraryDependencies ++= Seq(
  "org.http4s"              %% "http4s-blaze-server"  % http4sVersion,
  "org.http4s"              %% "http4s-dsl"           % http4sVersion,
  "org.http4s"              %% "http4s-blaze-client"  % http4sVersion,
  "org.sangria-graphql"     %% "sangria"              % "1.4.2",
  "org.sangria-graphql"     %% "sangria-spray-json"   % "1.0.1",
  "org.sangria-graphql"     %% "sangria-circe"        % "1.2.1",
  "org.tpolecat"            %% "doobie-core"          % doobieVersion,
  "org.tpolecat"            %% "doobie-postgres"      % doobieVersion,
  "org.tpolecat"            %% "doobie-hikari"        % doobieVersion,
  "org.typelevel"           %% "cats-core"            % catsVersion,
  "org.typelevel"           %% "cats-effect"          % catsVersion,
  "org.specs2"              %% "specs2-core"          % specs2Version % "test,it",
  "org.specs2"              %% "specs2-matcher-extra" % specs2Version % "test,it",
  "org.specs2"              %% "specs2-cats"          % specs2Version % "test,it",
  "org.tpolecat"            %% "doobie-specs2"        % doobieVersion % "test,it",
  "io.dropwizard.metrics"   % "metrics-core"          % "4.1.2" ,
  "io.github.azagniotov"    % "dropwizard-metrics-cloudwatch"  % "2.0.4",
  "io.circe"                %% "circe-core"           % circeVersion,
  "io.circe"                %% "circe-generic"        % circeVersion,
  "io.circe"                %% "circe-parser"         % circeVersion,
  "io.circe"                %% "circe-literal"        % circeVersion,
  "org.scala-sbt"           %% "io"                   % "1.3.1",
  "com.nimbusds"            % "nimbus-jose-jwt"       % "8.18"
)

target := new File(scala.util.Properties.envOrElse("TARGET_PATH", baseDirectory.value.getPath + "/target"))

enablePlugins(JavaAppPackaging)


