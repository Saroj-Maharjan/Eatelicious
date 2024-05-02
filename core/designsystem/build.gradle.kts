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
    implementation(libs.compose.ui)

    implementation(libs.androidx.core.ktx)
}