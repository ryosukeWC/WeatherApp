plugins {

    alias(libs.plugins.jetbrains.kotlin.jvm)
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