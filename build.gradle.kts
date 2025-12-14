plugins {
  kotlin("jvm") version "2.2.20"
  application
}

group = "io.github.urban233"
version = "1.0"

repositories {
  mavenCentral()
}

dependencies {
  implementation(files("libs/org.RDKit.jar"))
  testImplementation(kotlin("test"))
}

application {
  applicationDefaultJvmArgs = listOf(
    "-Djava.library.path=${layout.projectDirectory.dir("bin").asFile.absolutePath}"
  )
  mainClass.set("io.github.urban233.MainKt")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(21)
}
