plugins {
  id("io.github.gradle-nexus.publish-plugin")
}

tasks.register("clean", Delete::class) {
  delete(rootProject.layout.buildDirectory)
}
