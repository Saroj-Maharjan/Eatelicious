plugins {
    alias(libs.plugins.eatelicious.android.feature)
    alias(libs.plugins.eatelicious.android.library.compose)
    alias(libs.plugins.eatelicious.android.koin)
}

android {
    namespace = "com.sawrose.eatelicious.feature.bookmark"
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material3)
}