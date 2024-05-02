plugins {
    id("eatelicious.android.library")
}

android {
    namespace = "com.sawrose.eatelicious.core.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.kotlinx.coroutines.android)
}