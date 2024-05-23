plugins {
    id("eatelicious.android.library")
    id("eatelicious.android.koin")
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
    implementation(libs.circuit.runtime)
}