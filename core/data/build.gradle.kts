plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {

    implementation(libs.javax.inject)
    implementation(libs.coroutines.core)

    implementation(libs.okhttp.logging)
    implementation(libs.okhttp)

    implementation(project(":core:weatherapi"))
}