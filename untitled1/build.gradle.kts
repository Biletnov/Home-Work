plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.0.0")
}

tasks.test {
    useJUnitPlatform()
}