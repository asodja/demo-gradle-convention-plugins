import dependencies.Deps
import dependencies.Deps.projectLibrary

plugins {
    id("demo.java-library-module")
}

dependencies {
    // Sometimes you have to add "import dependencies.Deps" by hand :(
    implementation(Deps.guava)
    implementation(projectLibrary())
}