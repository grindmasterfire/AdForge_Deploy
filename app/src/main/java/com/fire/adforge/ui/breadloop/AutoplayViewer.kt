package com.fire.adforge.ui.breadloop

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.fire.adforge.R

@Composable
fun AutoplayViewer(
    isPlaying: Boolean,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val videoUri = remember { Uri.parse("android.resource://\/\") }

    AndroidView(
        modifier = modifier,
        factory = {
            VideoView(context).apply {
                setVideoURI(videoUri)
                setOnPreparedListener { mediaPlayer ->
                    mediaPlayer.isLooping = true
                    if (isPlaying) start()
                }
                setOnCompletionListener {
                    if (isPlaying) start()
                }
                setMediaController(MediaController(context).apply {
                    setAnchorView(this@apply)
                })
            }
        },
        update = { videoView ->
            if (isPlaying && !videoView.isPlaying) {
                videoView.start()
            } else if (!isPlaying && videoView.isPlaying) {
                videoView.pause()
            }
        }
    )
}

fun getAdQueueOrFallback(): List<String> {
    val primaryAds = SponsorAdLoader.loadSponsorAds() // normal inventory
    return if (primaryAds.isNotEmpty()) {
        primaryAds
    } else {
        listOf(
            "https://cdn.adforge.io/fallback1.mp4",
            "https://cdn.adforge.io/fallback2.mp4",
            "https://cdn.adforge.io/fallback3.mp4"
        )
    }
}
