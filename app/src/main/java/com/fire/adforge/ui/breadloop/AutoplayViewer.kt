package com.fire.adforge.ui.breadloop

import android.net.Uri
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.platform.LocalContext
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
