pluginManagement {
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

rootProject.name = "TinySteps"
include(":app")
include(":presentation:ui")
include(":presentation:viewmodels")
include(":domain:usecase")
include(":domain:models")
include(":data:repository")
include(":data:local")
include(":data:remote")
