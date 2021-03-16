import io.supercharge.plugin.Extensions.android
import io.supercharge.plugin.Extensions.applicationBuildFeatures

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.targetsdk)

    defaultConfig {
        minSdkVersion(Versions.minsdk)
        targetSdkVersion(Versions.targetsdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        compileOptions {
            isCoreLibraryDesugaringEnabled = true

            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    applicationBuildFeatures {
        dataBinding = true
    }

    buildTypes.getByName("release") {
        isMinifyEnabled = false
        proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
    }

    extensions.configure(org.jetbrains.kotlin.gradle.plugin.KaptExtension::class.java) {
        correctErrorTypes = true

        javacOptions {
            option("-Xmaxerrs", Int.MAX_VALUE)
        }
    }

    subprojects {
        tasks.withType(JavaCompile::class.java) {
            options.compilerArgs.addAll(listOf("-Xmaxerrs", "99999"))
        }
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java) {
        kotlinOptions {
            jvmTarget = org.gradle.api.JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs = listOf(
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=kotlinx.coroutines.FlowPreview"
            )
        }
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    add("coreLibraryDesugaring", Libraries.Common.jdk8desugar)

    // AndroidX
    implementation(Libraries.AndroidX.appcompat)
    implementation(Libraries.AndroidX.core)
    implementation(Libraries.AndroidX.lifecycleScope)
    implementation(Libraries.AndroidX.livedata)

    // UI
    implementation(Libraries.AndroidX.Ui.material)
    implementation(Libraries.AndroidX.Ui.constraintLayout)

    // Navigation
    implementation(Libraries.AndroidX.Navigation.core)
    implementation(Libraries.AndroidX.Navigation.ui)

    // Kotlin
    implementation(Libraries.Kotlin.coroutines)
    implementation(Libraries.Kotlin.coroutinesAndroid)

    // DI
    implementation(Libraries.Dagger.core)
    implementation(Libraries.Dagger.hilt)
    kapt(Libraries.Dagger.compiler)
    kapt(Libraries.Dagger.hiltCompiler)
    kapt(Libraries.Dagger.hiltCompiler)
    compileOnly(Libraries.Common.inject)

    // Test
    testImplementation(Libraries.Test.junit)
    testImplementation(Libraries.Test.mockito)
    testImplementation(Libraries.Test.truth)
    androidTestImplementation(Libraries.Test.espressoCore)
    androidTestImplementation(Libraries.Test.espressoContrib)
    androidTestImplementation(Libraries.Test.runner)
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.testCore)

    // Other
    implementation(Libraries.Common.timber)
    implementation(Libraries.Mock.fakeData)
    debugImplementation(Libraries.LeakCanary.canary)
    implementation(Libraries.LeakCanary.plumber)

}
