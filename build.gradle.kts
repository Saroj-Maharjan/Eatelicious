buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

// Lists all plugins used throughout the project without applying them.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.google.service) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.firebase.perf) apply false
    alias(libs.plugins.android.lint) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.roborazzi) apply false
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.secrets) apply false
    alias(libs.plugins.module.graph) apply true // Plugin applied to allow module graph generation
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}
