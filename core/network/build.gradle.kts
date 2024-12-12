plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.pligun)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.network"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 26

        buildConfigField("String", "BASE_URL_LOCATION_SERVICE", "\"http://dataservice.accuweather.com/locations/v1/\"");
        buildConfigField("String", "BASE_URL_WEATHER_SERVICE", "\"https://api.open-meteo.com/v1/\"");
        buildConfigField("String", "API_KEY", "\"9r8H8sS1hHM66DaWRROW2z5nc495LaGp\"")

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.retrofit)
    implementation(libs.retrofit.adapter.result)

    implementation(libs.coroutines.core)

    implementation(libs.okhttp)
    implementation(libs.gson)
    implementation(libs.gson.converter)
    implementation(libs.okhttp.logging)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
}