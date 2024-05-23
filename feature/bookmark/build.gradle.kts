plugins {
    id("eatelicious.android.feature")
    id("eatelicious.android.library.compose")
}

android {
    namespace = "com.sawrose.eatelicious.feature.bookmark"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material3)
    implementation(libs.circuit.foundation)
}