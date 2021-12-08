plugins {
    kotlin("jvm") version "1.5.+"
}

group = "me.furry"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.2.+")
    implementation("org.slf4j:slf4j-api:1.7.+")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    //implementation(kotlin("stdlib"))
}