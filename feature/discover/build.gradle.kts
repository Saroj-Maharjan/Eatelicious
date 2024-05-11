plugins {
    id("eatelicious.android.feature")
    id("eatelicious.android.library.compose")
    id("eatelicious.android.koin")
}

android {
    namespace = "com.sawrose.eatelicious.feature.discover"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:domain"))
    implementation(libs.coil.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material3)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewModelCompose)
}