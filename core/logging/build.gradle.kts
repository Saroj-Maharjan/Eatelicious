plugins {
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.eatelicious.android.koin)
}

android {
    namespace = "com.sawrose.eatelicious.core.logging"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)

    implementation(libs.androidx.metrics)
    implementation(libs.kotlinx.datetime)
}