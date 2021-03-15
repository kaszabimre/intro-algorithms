plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    // Gradle plugin dependencies
    implementation(gradleApi())

    // Android plugin dependencies
    implementation("com.android.tools.build:gradle:4.1.1")

    // Kotlin plugin dependencies
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.33-beta")
}
