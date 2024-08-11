rootProject.name = "Eatelicious"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "Eatelicious"
include(":app")
include(":data:recipe")
include(":data:cuisine")

include(":core:commons")
include(":core:data")
include(":core:domain")
include(":core:designsystem")
include(":core:logging")
include(":core:model")

//include(":sync")
include(":feature:discover")
include(":feature:mealplan")
include(":feature:bookmark")
include(":feature:compose-logviewer")


enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")