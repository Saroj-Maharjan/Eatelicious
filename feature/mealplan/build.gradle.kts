plugins {
    id("eatelicious.android.feature")
    id("eatelicious.android.library.compose")
}

android {
    namespace = "com.sawrose.eatelicious.feature.mealplan"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material3)
}