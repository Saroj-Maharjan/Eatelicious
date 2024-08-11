plugins {
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.eatelicious.android.library.compose)
}

android {
    namespace = "com.sawrose.eatelicious.core.designsystem"
}

dependencies {
    api(libs.compose.foundation)
    api(libs.compose.foundation.layout)
    api(libs.compose.material.iconsext)
    api(libs.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.compose.material3.navigationSuite)
    api(libs.compose.ui.util)
    api(libs.compose.menuprovider)

    implementation(libs.androidx.core.ktx)
}