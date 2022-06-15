package commons

import dependencies.Deps
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.`java-library`

plugins {
    `java-library`
}

fun String.version(): String = this.split(":")[2]

dependencies {
    // Create constraints so we have these versions
    // in all projects that applies this plugin
    constraints {
        Deps.dependenciesWithVersion().forEach {
            implementation(it) {
                // Optionally replace prefer with strict,
                // so really only this version that is set in Deps will be used and no other.
                version {
                    prefer(it.version())
                }
            }
            api(it) {
                // Optionally replace prefer with strict,
                // so really only this version that is set in Deps will be used and no other.
                version {
                    prefer(it.version())
                }
            }
        }
    }

    // Add global Boms
    // Optionally use enforcedPlatform,
    // if you want to force versions from bom (similar as Maven).
    // If you have conflict with "strict" and "enforcedPlatform" you have to add excludes to bom
    implementation(platform(Deps.googleCloudBom))
}

configurations.all {
    // Add global excludes...
}

