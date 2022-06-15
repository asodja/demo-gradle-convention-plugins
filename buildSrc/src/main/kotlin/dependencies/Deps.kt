package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Deps {

    private val dependenciesWithVersion = mutableListOf<String>()

    // Libraries
    // Alternatively you can also use version catalog https://docs.gradle.org/current/userguide/platforms.html,
    // but if you want IDE support this way is better atm
    val guava = dependency("com.google.guava:guava:31.1-jre")
    val googleCloudBom = dependency("com.google.cloud:libraries-bom:25.4.0")



    // Projects
    // You can also have project accessors
    // with enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS") in settings.gradle.kts but it's not a stable feature
    fun DependencyHandler.projectLibrary() = this.project(":library")
    fun DependencyHandler.projectWeb() = this.project(":web")



    fun dependenciesWithVersion(): List<String> {
        return dependenciesWithVersion
    }

    private fun dependency(value: String): String {
        val vals = value.split(":")
        if (vals.size >= 3) {
            dependenciesWithVersion.add(value)
        }
        return value
    }
}