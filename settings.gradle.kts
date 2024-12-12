pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "WeatherApp"
include(":app")
include(":core")
include(":core:data")
include(":core:common")
include(":core:network")
include(":feature")
include(":feature:weather-main")
include(":feature:weather-main:ui")
include(":feature:settings")
include(":feature:city-search")
include(":feature:splash-screen")
