plugins {
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.eatelicious.android.library.compose)
    alias(libs.plugins.eatelicious.android.koin)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.sawrose.eatelicious.data.recipe"
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