plugins {
    id("eatelicious.android.library")
    id("eatelicious.android.library.compose")
}

android {
    namespace = "com.sawrose.eatelicious.core.designsystem"
}

dependencies {
    implementation(libs.compose.foundation)
    implementation(libs.compose.foundation.layout)
    implementation(libs.compose.material.iconsext)
    implementation(libs.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.compose.material3.navigationSuite)
    implementation(libs.compose.ui)

    implementation(libs.androidx.core.ktx)
}