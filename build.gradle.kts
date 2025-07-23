plugins {
    id("com.android.application") version "8.2.2" apply true
    id("org.jetbrains.kotlin.android") version "1.9.10" apply true
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
    }
}
