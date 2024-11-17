plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.practice.weatherapp.core.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }
}


dependencies {

    implementation(libs.javax.inject)
    implementation(libs.coroutines.core)

    implementation(libs.okhttp.logging)
    implementation(libs.okhttp)

    implementation(libs.location)

    // implementation(project(":core:weatherapi"))
}