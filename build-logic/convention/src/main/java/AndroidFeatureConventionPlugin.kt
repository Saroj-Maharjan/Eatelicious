import com.android.build.gradle.LibraryExtension
import com.sawrose.eatelicious.configureGradleManagedDevices
import com.sawrose.eatelicious.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("eatelicious.android.library")
//                apply("eatelicious.android.hilt")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        "com.sawrose.eatelicious.core.testing.NiaTestRunner"
                }
                configureGradleManagedDevices(this)
            }

            dependencies {
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:data"))
                add("implementation", project(":core:commons"))
                add("implementation", project(":core:domain"))

                add("testImplementation", kotlin("test"))
//                add("testImplementation", project(":core:testing"))
                add("androidTestImplementation", kotlin("test"))
//                add("androidTestImplementation", project(":core:testing"))
//
//                add("implementation", libs.findLibrary("coil.kt").get())
//                add("implementation", libs.findLibrary("coil.kt.compose").get())

                add("implementation", libs.findLibrary("koin.compose.navigation").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}