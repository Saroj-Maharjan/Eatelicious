plugins {
    id("eatelicious.android.library")
}

android {
    namespace = "com.sawrose.eatelicious.sync"
}

dependencies {
    implementation(libs.androidx.startup.runtime)
    implementation(libs.androidx.work.runtime.ktx)
}