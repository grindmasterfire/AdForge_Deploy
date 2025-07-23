﻿pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10" apply false
}
buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
    }
}
