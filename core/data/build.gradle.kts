plugins {
    id("eatelicious.android.library")
    id("eatelicious.android.room")
    id("eatelicious.android.koin")
    id("kotlinx-serialization")
}

android {
    namespace = "com.sawrose.eatelicious.core.data"
}

dependencies {
    implementation(project(":core:commons"))
    implementation(project(":core:model"))


    implementation(libs.bundles.network)
    implementation(libs.mobilenativefoundation.store)
}