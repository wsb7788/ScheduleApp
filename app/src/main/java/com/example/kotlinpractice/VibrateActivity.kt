package com.example.kotlinpractice

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_vibrate.*

class VibrateActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)

        vib_Btn.setOnClickListener { Vibration(1000L) }
    }
    fun Vibration(len: Long) {
        val vibrtator = getSystemService(VIBRATOR_SERVICE) as Vibrator
        vibrtator.vibrate(len)

    }

}

