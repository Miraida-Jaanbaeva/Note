object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val jvm = "org.jetbrains.kotlin.jvm"
        const val kapt = "kotlin-kapt"
        const val serialization = "plugin.serialization"
    }

    object Java {
        const val java = "java-library"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }
}

object Dependencies {

    object UI {
        const val core = ("androidx.core:core-ktx:${Versions.core}")
        const val appcompat = ("androidx.appcompat:appcompat:${Versions.appcompat}")
        const val material = ("com.google.android.material:material:${Versions.material}")
        const val constraint = ("androidx.constraintlayout:constraintlayout:${Versions.constraint}")
        const val fragment = ("androidx.fragment:fragment-ktx:${Versions.fragment}")
        const val legacy = ("androidx.legacy:legacy-support-v4:${Versions.legacy}")
        const val lifecycleLivedata =
            ("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedata}")
        const val lifecycleViewModel = ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object DaggerHilt {
        const val android = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"

    }

    object Nav {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    }

    object Coroutine {
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
    }

    const val javax = "javax.inject:javax.inject:1"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0"
    const val gson = "com.google.code.gson:gson:2.9.0"
}

object Versions {

    const val core = "1.7.0"
    const val appcompat = "1.6.1"
    const val material = "1.8.0"
    const val constraint = "2.1.4"
    const val fragment = "1.5.5"
    const val legacy = "1.0.0"
    const val lifecycleLivedata = "2.5.1"

    const val AGP = "7.3.1"
    const val kotlin = "1.8.10"
    const val daggerHilt = "2.44"
    const val nav = "2.5.3"
    const val room = "2.5.0"
    const val serialization = "1.8.10"
}