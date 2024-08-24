plugins {
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.eatelicious.android.library.compose)
    alias(libs.plugins.eatelicious.android.koin)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.sawrose.eatelicious.data.bookmark"
}

dependencies {
    implementation(projects.core.designsystem)
}