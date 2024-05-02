buildscript {
  repositories {
    google()
    mavenCentral()

    // Android Build Server
    maven { url = uri("../eatelicious-prebuilts/m2repository") }
  }
  //    dependencies {
  //        classpath(libs.google.oss.licenses.plugin) {
  //            exclude(group = "com.google.protobuf")
  //        }
  //    }
}

// Lists all plugins used throughout the project without applying them.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.kotlin.serialization) apply false
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.roborazzi) apply false
  alias(libs.plugins.android.library) apply false
}
