plugins{
    alias(libs.plugins.eatelicious.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.sawrose.eatelicious.core.navigation"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.kotlinx.serialization.json)
}