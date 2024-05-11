plugins {
    id("eatelicious.android.library")
    id("eatelicious.android.koin")
}

android {
    namespace = "com.sawrose.eatelicious.core.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))

    implementation(libs.kotlinx.coroutines.android)
}