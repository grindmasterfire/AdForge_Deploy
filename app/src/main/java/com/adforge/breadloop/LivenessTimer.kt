package com.adforge.breadloop

import kotlinx.coroutines.*
import kotlin.random.Random

object LivenessTimer {
    private var job: Job? = null

    fun startLivenessCheck(onTrigger: () -> Unit) {
        job?.cancel()
        job = CoroutineScope(Dispatchers.Default).launch {
            val delayMillis = Random.nextLong(120_000L, 420_000L) // 27 minutes
            delay(delayMillis)
            withContext(Dispatchers.Main) {
                onTrigger()
            }
        }
    }

    fun cancel() {
        job?.cancel()
    }
}
