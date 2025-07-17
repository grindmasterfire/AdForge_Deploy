package com.fire.adforge.core

enum class BuildStage {
    DEV, ALPHA, BETA, RELEASE
}

object StageFlags {
    val current = BuildStage.ALPHA

    val isDebug: Boolean get() = current == BuildStage.DEV
    val isAlpha: Boolean get() = current == BuildStage.ALPHA
    val isBeta: Boolean get() = current == BuildStage.BETA
    val isRelease: Boolean get() = current == BuildStage.RELEASE
}
