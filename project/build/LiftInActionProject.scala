import sbt._
import eu.getintheloop.Native2AsciiPlugin
import reaktor.scct.ScctProject

class lLiftInActionProject(info: ProjectInfo) extends ParentProject(info) with IdeaProject {
  val liftVersion = "2.3"
  val h2Version = "1.3.146"

  // implement the module definitions
  lazy val chpTwo = project("chapter-2", "2", new ChapterTwo(_))
  lazy val chpThree = project("chapter-3", "3", new ChapterThree(_))
  lazy val chpFour = project("chapter-4", "4", new ChapterFour(_))
  lazy val chpFive = project("chapter-5", "5", new ChapterFive(_))
  // Common Tasks with Lift Webkit
  lazy val chpSix = project("chapter-6", "6", new ChapterSix(_))
  // SiteMap
  lazy val chpSeven = project("chapter-7", "7", new ChapterSeven(_))
  // HTTP within Lift
  lazy val chpEight = project("chapter-8", "8", new ChapterEight(_))
  // AJAX, Wiring and Comet
  lazy val chpNine = project("chapter-9", "9", new ChapterNine(_))
  // Persistence with Mapper
  lazy val chpTen = project("chapter-10", "10", new ChapterTen(_))
  // Persistance with Record
  lazy val chpEleven = project("chapter-11", "11", new ChapterEleven(_))
  // Loalization
  lazy val chpTwelve = project("chapter-12", "12", new ChapterTwelve(_))
  // Enterprise lift
  lazy val chpThirteen = project("chapter-13", "13", new ChapterThirteen(_))
  // Application Testing
  lazy val chpFourteen = project("chapter-14", "14", new ChapterFourteen(_))
  // Deployment and Scaling
  lazy val chpFifteen = project("chapter-15", "15", new ChapterFifteen(_))

  // define each module and any specific dependencies that it has
  // As chapter one is so basic, it has no specilized deps
  class ChapterTwo(info: ProjectInfo) extends ProjectDefaults(info)

  // chapter two requires mapper, as we'll be doing some database stuff
  class ChapterThree(info: ProjectInfo)
      extends ChapterTwo(info)
      with DatabaseDrivers
  {
    val mapper = "net.liftweb" %% "lift-mapper" % liftVersion % "compile"
  }

  class ChapterFour(info: ProjectInfo)
      extends ChapterThree(info)
      with DatabaseDrivers
  {
    val textile = "net.liftweb" %% "lift-textile" % liftVersion % "compile"
  }

  class ChapterFive(info: ProjectInfo)
      extends ChapterFour(info)
      with DatabaseDrivers
  {
    val machine = "net.liftweb" %% "lift-machine" % liftVersion % "compile"
    val paypal = "net.liftweb" %% "lift-paypal" % liftVersion % "compile"
  }

  class ChapterSix(info: ProjectInfo) extends ProjectDefaults(info){
    val wizard = "net.liftweb" %% "lift-wizard" % liftVersion % "compile"
    val widgets = "net.liftweb" %% "lift-widgets" % liftVersion % "compile"
    val scalate = "net.liftweb" %% "lift-scalate" % liftVersion % "compile"
  }

  class ChapterSeven(info: ProjectInfo)
      extends ProjectDefaults(info)
      with DatabaseDrivers
  {
    val mapper = "net.liftweb" %% "lift-mapper" % liftVersion % "compile"
    val textile = "net.liftweb" %% "lift-textile" % liftVersion % "compile"
  }

  class ChapterEight(info: ProjectInfo) extends ProjectDefaults(info)

  class ChapterNine(info: ProjectInfo) extends ProjectDefaults(info)

  class ChapterTen(info: ProjectInfo)
      extends ProjectDefaults(info)
      with DatabaseDrivers
  {
    val mapper = "net.liftweb" %% "lift-mapper" % liftVersion % "compile"
  }

  class ChapterEleven(info: ProjectInfo)
      extends ProjectDefaults(info)
      with DatabaseDrivers
  {
    val squeryl = "net.liftweb" %% "lift-squeryl-record" % liftVersion % "compile"
    val couch = "net.liftweb" %% "lift-couchdb" % liftVersion % "compile"
    val mongo = "net.liftweb" %% "lift-mongodb-record" % liftVersion % "compile"
    // statically supplied the 2.8.1 version as the versions in scala-tools
    // requires 2.4-SNAPSHOT of Lift which the book does not use.
    // val rogue = "com.foursquare" %% "rogue" % "1.0.10" % "compile"
  }

  class ChapterTwelve(info: ProjectInfo)
      extends ProjectDefaults(info)
      with Native2AsciiPlugin

  class ChapterThirteen(info: ProjectInfo)
      extends ChapterFour(info)
      with DatabaseDrivers
  {
    val jpa = "net.liftweb" %% "lift-jpa" % liftVersion % "compile"
    val jta = "net.liftweb" %% "lift-jta" % liftVersion % "compile"
    val amqp = "net.liftweb" %% "lift-amqp" % liftVersion % "compile"
    val akka = "se.scalablesolutions.akka" % "akka-actor" % "1.0" % "compile"
    val remote = "se.scalablesolutions.akka" % "akka-remote" % "1.0" % "compile"
    val hibem = "org.hibernate" % "hibernate-entitymanager" % "3.6.0.Final" % "compile"
    val hibval = "org.hibernate" % "hibernate-validator-annotation-processor" % "4.1.0.Final" % "compile"
    val javassist = "javassist" % "javassist" % "3.12.1.GA" % "compile"

  }

  class ChapterFourteen(info: ProjectInfo)
      extends ProjectDefaults(info)
      with DatabaseDrivers
      with ScctProject
  {
    val mapper = "net.liftweb" %% "lift-mapper" % liftVersion % "compile"
    val testkit = "net.liftweb" %% "lift-testkit" % liftVersion % "test"
    val scalatest = "org.scalatest" % "scalatest" % "1.3" % "test"
    val specs = "org.scala-tools.testing" %% "specs" % "1.6.7.2" % "test"
    val scalacheck = "org.scala-tools.testing" %% "scalacheck" % "1.8" % "test"
    val jwebunit = "net.sourceforge.jwebunit" % "jwebunit-htmlunit-plugin" % "2.5" % "test"
    // selenium
    val selenium = "org.seleniumhq.selenium" % "selenium-java" % "2.3.1" % "test"
    val seleniumsvr = "org.seleniumhq.selenium" % "selenium-server" % "2.3.1" % "test"
    // configure the testing classpath
    override def testClasspath  = super.testClasspath +++ ("src" / "main" / "webapp")
  }

  class ChapterFifteen(info: ProjectInfo)
      extends ProjectDefaults(info)
      with DatabaseDrivers
  {
    val ostrich = "com.twitter" % "ostrich" % "4.1.0" % "compile"
    val mapper = "net.liftweb" %% "lift-mapper" % liftVersion % "compile"
  }

  trait DatabaseDrivers { _: DefaultWebProject =>
    // usually you would only use one database type, not three; this gives you
    // options as to what you want to use though.
    val h2 = "com.h2database" % "h2" % h2Version % "compile"
    val mysql = "mysql" % "mysql-connector-java" % "5.1.12" % "compile"
    val postgresql = "postgresql" % "postgresql" % "9.0-801.jdbc4" % "compile"
  }

  // define some defaults
  abstract class ProjectDefaults(info: ProjectInfo)
      extends DefaultWebProject(info)
      with IdeaProject {

    override def compileOptions = Unchecked :: Deprecation :: super.compileOptions.toList

    // deployment
    override def managedStyle = ManagedStyle.Maven
    override def jettyWebappPath = webappPath
    override def scanDirectories = Nil

    // every chapter will be using lift (of course!)
    val webkit = "net.liftweb" %% "lift-webkit" % liftVersion % "compile"
    val logback = "ch.qos.logback" % "logback-classic" % "0.9.24" % "compile"
    val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided"
    val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.21" % "test"
    // val log4j = "org.slf4j" % "slf4j-log4j12" % "1.6.1" % "compile"

    object Repositories {
      lazy val MavenLocal           = MavenRepository("local.repo", "file://"+Path.userHome+"/.m2/repository")
      lazy val MavenCentral         = MavenRepository("central.repo", "http://repo1.maven.org/maven2/")
      lazy val JBossRepo            = MavenRepository("jboss.repo", "http://repository.jboss.org/nexus/content/groups/public-jboss/")
      lazy val TwitterRepo          = MavenRepository("twitter.repo", "http://maven.twttr.com/")
      lazy val ScalaToolsReleases   = MavenRepository("scala-tools.releases", "http://scala-tools.org/repo-releases/")
      lazy val ScalaToolsSnapshots  = MavenRepository("scala-tools.snapshots", "http://scala-tools.org/repo-snapshots/")
      lazy val SonatypeRepo         = MavenRepository("oss.sonatype.org", "http://oss.sonatype.org/content/groups/github/")
      lazy val AkkaRepo             = MavenRepository("akka.repo", "http://repo.typesafe.com/typesafe/releases")
      lazy val GuiceyFruitRepo      = MavenRepository("guiceyfruit.repo", "http://guiceyfruit.googlecode.com/svn/repo/releases/")
    }

    import Repositories._
    // module Configurations
    lazy val localMavenRepo           = MavenLocal
    lazy val avalonModuleConfig       = ModuleConfiguration("avalon-framework", MavenCentral)
    lazy val logkitModuleConfig       = ModuleConfiguration("logkit", MavenCentral)
    lazy val liftModuleConfig         = ModuleConfiguration("net.liftweb", ScalaToolsReleases)
    lazy val scalaTestModuleConfig    = ModuleConfiguration("org.scalatest", ScalaToolsReleases)
    lazy val specsModuleConfig        = ModuleConfiguration("org.scala-tools.testing", ScalaToolsReleases)
    lazy val akkaModuleConfig         = ModuleConfiguration("se.scalablesolutions.akka", AkkaRepo)
    lazy val uuidModuleConfig         = ModuleConfiguration("com.eaio", AkkaRepo)
    lazy val sbinaryModuleConfig      = ModuleConfiguration("sbinary", AkkaRepo)
    lazy val jsr166xModuleConfig      = ModuleConfiguration("jsr166x", AkkaRepo)
    lazy val voldemortModuleConfig    = ModuleConfiguration("voldemort.store.compress", AkkaRepo)
    lazy val sjsonModuleConfig        = ModuleConfiguration("sjson.json", AkkaRepo)
    lazy val nettyModuleConfig        = ModuleConfiguration("org.jboss.netty", JBossRepo)
    lazy val aspeketModuleConfig      = ModuleConfiguration("org.codehaus.aspectwerkz", AkkaRepo)
    lazy val twitterModuleConfig      = ModuleConfiguration("com.twitter", TwitterRepo)
    lazy val lagNetCustModuleConfig   = ModuleConfiguration("net.lag", "configgy", "2.0.2-nologgy", AkkaRepo)
    lazy val lagNetModuleConfig       = ModuleConfiguration("net.lag", "configgy", "2.0.2", TwitterRepo)
    lazy val hibernateModuleConfig    = ModuleConfiguration("org.hibernate", JBossRepo)
    lazy val javaxPersModuleConfig    = ModuleConfiguration("org.hibernate.javax.persistence", JBossRepo)
    lazy val jettyModuleConfig        = ModuleConfiguration("org.eclipse.jetty", DefaultMavenRepository)
    lazy val guiceyFruitModuleConfig  = ModuleConfiguration("org.guiceyfruit", GuiceyFruitRepo)
    lazy val jbossModuleConfig        = ModuleConfiguration("org.jboss", JBossRepo)
    lazy val logbackModuleConfig      = ModuleConfiguration("ch.qos.logback", sbt.DefaultMavenRepository)
    lazy val javassistConfig          = ModuleConfiguration("javassist", "javassist", "3.12.1.GA", MavenCentral)
  }
}
