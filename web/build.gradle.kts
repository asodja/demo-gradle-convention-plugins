import dependencies.Deps

plugins {
    id("demo.java-web-module")
}

dependencies {
    // Sometimes you have to add "import dependencies.Deps" by hand :(
    implementation(Deps.guava)
}

application {
    // Define the main class for the application.
    mainClass.set("demo.gradle.convention.plugins.app.App")
}
