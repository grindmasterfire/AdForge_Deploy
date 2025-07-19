plugins {
    id("com.android.application") version "8.1.0" version "8.1.0"
    id("org.jetbrains.kotlin.android") version "1.9.0"
}

android {
    namespace = "com.fire.adforge"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fire.adforge"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {\n        release {\n            signingConfig signingConfigs.release
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}




