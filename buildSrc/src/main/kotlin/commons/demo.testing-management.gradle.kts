package commons

plugins {
    `java-library`
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}