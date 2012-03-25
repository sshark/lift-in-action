import sbt._
class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  lazy val n2a = "eu.getintheloop" % "sbt-native2ascii-plugin" % "0.1.0"
  lazy val scctPlugin = "reaktor" % "sbt-scct-for-2.8" % "0.1-SNAPSHOT"
  lazy val sbtIdea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.4.0"
  // repos
  val sonaTypeGithubRepo = "sonatype.repo.github" at "http://oss.sonatype.org/content/groups/github/"
  val sonatypeRepo = "sonatype.repo" at "https://oss.sonatype.org/content/groups/public"
  val scctRepo = "scct.repo" at "http://mtkopone.github.com/scct/maven-repo/"
  val sbtIdeaRepo = "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
}
