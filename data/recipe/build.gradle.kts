import java.util.Properties

plugins {
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.eatelicious.android.library.compose)
    alias(libs.plugins.eatelicious.android.koin)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.sawrose.eatelicious.data.recipe"
    defaultConfig {
        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField(
            "String",
            "SPOONCULAR_API_KEY",
            "\"${properties.getProperty("sponcular_api")}\"",
        )
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.logging)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.model)

    implementation(libs.ktor.core)
    implementation(libs.androidx.metrics)
    implementation(libs.mobilenativefoundation.store)
}