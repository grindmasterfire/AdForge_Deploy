package com.adforge.app

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.adforge.app.databinding.ActivityBreadloopAdBinding
import kotlin.random.Random

class BreadloopAdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBreadloopAdBinding
    private lateinit var timer: CountDownTimer
    private val handler = Handler(Looper.getMainLooper())
    private val sessionLengthMillis = 15 * 60_000L
    private var livenessShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreadloopAdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startCountdown()
        scheduleLivenessPopup()
    }

    private fun startCountdown() {
        timer = object : CountDownTimer(sessionLengthMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val min = millisUntilFinished / 60_000
                val sec = (millisUntilFinished % 60_000) / 1000
                binding.timerText.text = String.format("Watching Ad... %02d:%02d remaining", min, sec)
            }

            override fun onFinish() {
                binding.timerText.text = "Ad Complete!"
                Toast.makeText(this@BreadloopAdActivity, "Raffle Ready", Toast.LENGTH_SHORT).show()

                RaffleEntryEngine.recordEntry("BREADLOOP")
            }
        }.start()
    }

    private fun scheduleLivenessPopup() {
        val delayMillis = Random.nextLong(2 * 60_000L, 7 * 60_000L)
        handler.postDelayed({
            if (!livenessShown) {
                showLivenessDialog()
                livenessShown = true
            }
        }, delayMillis)
    }

    private fun showLivenessDialog() {
        AlertDialog.Builder(this)
            .setTitle("Liveness Check")
            .setMessage("Tap 'I'm Here' to stay active.")
            .setCancelable(false)
            .setPositiveButton("I'm Here") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("Exit") { _, _ ->
                timer.cancel()
                finish()
            }
            .show()
    }

    override fun onDestroy() {
        if (::timer.isInitialized) timer.cancel()
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
