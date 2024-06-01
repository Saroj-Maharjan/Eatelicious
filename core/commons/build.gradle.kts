plugins {
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.eatelicious.android.library.compose)
    alias(libs.plugins.eatelicious.android.koin)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.sawrose.eatelicious.eatelicious.commons"

    defaultConfig {
        buildConfigField(
            "String",
            "SPOONCULAR_API_KEY",
            "\"${project.findProperty("sponcular_api")}\""
        )
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:logging"))
    implementation(libs.androidx.metrics)
}