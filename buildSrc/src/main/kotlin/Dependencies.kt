@file:Suppress("InvalidPackageDeclaration")

object Versions {
    const val minsdk = 26
    const val targetsdk = 30

    const val appcompat = "1.2.0"
    const val core = "1.5.0-beta02"
    const val kotlin = "1.4.30"
    const val coroutines = "1.4.2"
    const val dagger = "2.31.2"
    const val hilt = "2.33-beta"
    const val lifecycle = "2.3.0"
    const val navigation = "2.3.4"
    const val leakcanary = "2.5"

    const val material = "1.3.0"
    const val constraintLayout = "2.0.4"

    const val junit = "4.13.2"
    const val junitExt = "1.1.3-alpha05"
    const val runner = "1.4.0-alpha05"
    const val espresso = "3.4.0-alpha05"
    const val mockito = "1.10.19"
    const val truth = "1.1.2"
    const val testCore = "1.4.0-alpha05"
}

object Libraries {

    object Kotlin {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val lifecycleScope = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

        object Ui {
            const val material = "com.google.android.material:material:${Versions.material}"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        }

        object Navigation {
            const val core = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }
    }

    object Common {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
        const val inject = "javax.inject:javax.inject:1"
        const val jdk8desugar = "com.android.tools:desugar_jdk_libs:1.1.1"
    }

    object LeakCanary {
        const val canary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
        const val plumber = "com.squareup.leakcanary:plumber-android:${Versions.leakcanary}"
    }

    object Mock {
        const val fakeData = "com.github.blocoio:faker:1.2.8"
    }

    object Test {
        const val testCore = "androidx.test:core:${Versions.testCore}"
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val runner = "androidx.test:runner:${Versions.runner}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
        const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
        const val truth = "com.google.truth:truth:${Versions.truth}"
    }
}
