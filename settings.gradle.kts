pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Eatelicious"
include(":app")

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