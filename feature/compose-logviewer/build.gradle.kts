plugins {
    id("eatelicious.android.feature")
    id("eatelicious.android.library.compose")
    id("eatelicious.android.koin")
}

android {
    namespace = "com.sawrose.eatelicious.feature.logviewer"
}

dependencies {
    implementation(projects.core.logging)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material3)
    implementation(libs.kotlinx.datetime)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewModelCompose)
}