plugins {
  id("ignite.base-conventions")
  `maven-publish`
  signing
}

// Expose version catalog
val libs = extensions.getByType(org.gradle.accessors.dm.LibrariesForLibs::class)

java {
  withJavadocJar()
}

publishing {
  repositories {
    maven {
      name = "MonumentaMaven"
      url = when (version.toString().endsWith("SNAPSHOT")) {
        true -> uri("https://maven.playmonumenta.com/snapshots")
        false -> uri("https://maven.playmonumenta.com/releases")
      }

      credentials {
        username = System.getenv("USERNAME")
        password = System.getenv("TOKEN")
      }
    }
  }
  publications {
    create<MavenPublication>("mavenJava") {
      from(components["java"])

      pom {
        name.set(project.name)
        description.set(project.description)
        url.set("https://maven.floweytf.com/snapshots")

        licenses {
          license {
            name.set("MIT License")
            url.set("https://opensource.org/licenses/MIT")
          }
        }

        developers {
          developer {
            id.set("vectrix")
            name.set("Vectrix")
          }
          developer {
            id.set("Floweynt")
            name.set("Floweynt")
          }
        }

        scm {
          connection.set("scm:git:https://github.com/Floweynt/ignite-fork.git")
          developerConnection.set("scm:git:https://github.com/Floweynt/ignite-fork.git")
          url.set("https://github.com/Floweynt/ignite-fork.git")
        }
      }
    }
  }
}
