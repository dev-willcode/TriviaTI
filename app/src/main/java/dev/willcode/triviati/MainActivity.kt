package dev.willcode.triviati

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        playSound()
        MobileAds.initialize(this) {}
    }

    private fun playSound() {
        mp = MediaPlayer.create(this, R.raw.chiptune)
        mp.isLooping = true
        mp.start()
    }

    override fun onPause() {
        super.onPause()
        mp.pause()
    }

    override fun onResume() {
        super.onResume()
        mp.start()
    }
}