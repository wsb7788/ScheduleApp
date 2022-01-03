package com.example.kotlinpractice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_vibrate.*

class PushAlarmActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)


        vib_Btn.setOnClickListener { ShowNotification("asd","asdas") }
    }

    fun ShowNotification(Title: String, Body: String){
        val pending = PendingIntent.getActivity(this,0,Intent(this, MainActivity::class.java), PendingIntent.FLAG_CANCEL_CURRENT)
        val builder = NotificationCompat.Builder(this, "id")
        builder.setSmallIcon(R.drawable.ic_baseline_favorite_24)
            .setContentTitle(Title)
            .setContentText(Body)
            .setContentIntent(pending)
            .setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE)

        val NManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NManager.createNotificationChannel(NotificationChannel("id", "name", NotificationManager.IMPORTANCE_HIGH))
        }
        NManager.notify(0, builder.build())
    }
}