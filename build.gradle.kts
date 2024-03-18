plugins {
    id("java")
    id("io.ktor.plugin") version "2.3.9"
}

application {
    mainClass.set("org.alksndrstjc.Main")
}

group = "org.alksndrstjc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

ktor {
    fatJar {
        archiveFileName.set("rlimit.jar")
    }
}

tasks.test {
    useJUnitPlatform()
}