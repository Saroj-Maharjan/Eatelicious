plugins {
    id("eatelicious.android.library")
    id("eatelicious.android.koin")
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.sawrose.eatelicious.eatelicious.commons"
}

dependencies {
    implementation(libs.circuit.runtime)
}