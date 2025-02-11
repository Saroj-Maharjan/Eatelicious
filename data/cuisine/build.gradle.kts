import java.util.Properties

plugins {
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.eatelicious.android.library.compose)
    alias(libs.plugins.eatelicious.android.koin)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.sawrose.eatelicious.data.cuisine"
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.logging)
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.domain)

    implementation(libs.ktor.core)

    implementation(libs.androidx.metrics)
    implementation(libs.mobilenativefoundation.store)
}