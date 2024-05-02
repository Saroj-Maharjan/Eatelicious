plugins {
    id("eatelicious.android.feature")
    id("eatelicious.android.library.compose")
}

android {
    namespace = "com.sawrose.eatelicious.feature.discover"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material3)
    implementation(libs.androidx.lifecycle.viewModelCompose)
}