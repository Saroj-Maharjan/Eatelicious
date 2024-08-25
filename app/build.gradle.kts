import com.sawrose.eatelicious.EateliciousBuildType

plugins {
    alias(libs.plugins.eatelicious.android.application)
    alias(libs.plugins.eatelicious.android.application.compose)
    alias(libs.plugins.eatelicious.android.application.firebase)
    alias(libs.plugins.eatelicious.android.application.flavors)
    alias(libs.plugins.eatelicious.android.koin)
//    id("com.google.android.gms.oss-licenses-plugin")
}

android {

    namespace = "com.sawrose.eatelicious"

    defaultConfig {
        applicationId = "com.sawrose.eatelicious"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix =
                EateliciousBuildType.DEBUG.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix =
                EateliciousBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.named("debug").get()
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(projects.core.logging)

    implementation(projects.data.recipe)
    implementation(projects.data.cuisine)
    implementation(projects.data.logs)

    implementation(projects.feature.discover)
    implementation(projects.feature.bookmark)
    implementation(projects.feature.mealplan)
    implementation(projects.feature.composeLogviewer)

    implementation(libs.androidx.splash.screen)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.window.size)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.accomponist.adaptive)

    implementation(libs.compose.foundation)
    implementation(libs.compose.foundation.layout)
    implementation(libs.compose.ui)
    implementation(libs.compose.material.iconsext)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)

    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.androidx.navigation.testing)

    implementation(libs.androidx.metrics)
    implementation(libs.kotlinx.datetime)

    implementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.kotlinx.coroutines.test)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)

    testImplementation(libs.junit)

    implementation(platform(libs.firebase.bom))

    androidTestImplementation(libs.androidx.junit.ext)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}