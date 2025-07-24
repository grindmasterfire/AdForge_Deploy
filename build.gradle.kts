pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
\nbuildscript {\n    dependencies {\n        classpath("com.google.gms:google-services:4.4.0")\n    }\n    repositories {\n        google()\n        mavenCentral()\n    }\n}
    plugins {
        id("com.android.application") version "8.2.2"
        kotlin("android") version "1.9.10"
        kotlin("plugin.serialization") version "1.9.10"
    }
}

plugins {
    kotlin("plugin.serialization") version "1.9.10"
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

