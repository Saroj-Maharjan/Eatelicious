import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.sawrose.eatelicious.configureGradleManagedDevices
import com.sawrose.eatelicious.configureKotlinAndroid
import com.sawrose.eatelicious.configurePrintApksTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.application")
            apply(plugin = "org.jetbrains.kotlin.android")
            apply(plugin = "com.dropbox.dependency-guard")

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 35
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
                configureGradleManagedDevices(this)
            }

            extensions.configure<ApplicationAndroidComponentsExtension> {
                configurePrintApksTask(this)
            }
        }
    }
}