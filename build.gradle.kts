import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.32"
    `maven-publish`
}

group = "me.furry"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("ch.qos.logback:logback-classic:1.2.7")
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "16"
}