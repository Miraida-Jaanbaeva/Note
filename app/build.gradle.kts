plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.lecture_1a_7"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.lecture_1a_7"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(Dependencies.UI.core)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraint)
    implementation(Dependencies.UI.fragment)
    implementation(Dependencies.UI.legacy)
    implementation(Dependencies.UI.lifecycleLivedata)
    implementation(Dependencies.UI.lifecycleViewModel)

    //DI Hilt
    implementation(Dependencies.DaggerHilt.android)
    kapt(Dependencies.DaggerHilt.compiler)

    //Coroutine
    implementation(Dependencies.Coroutine.android)

    // Nav
    implementation(Dependencies.Nav.fragment)
    implementation(Dependencies.Nav.ui)

    //Gson
    implementation(Dependencies.gson)

    //Room
    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.runtime)
}