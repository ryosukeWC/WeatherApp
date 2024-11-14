plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.adapter.result)

    implementation(libs.coroutines.core)

    implementation(libs.okhttp)
    implementation(libs.gson)
    implementation(libs.gson.converter)
    implementation(libs.okhttp.logging)

    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
}