package com.example.android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_t_p9.*

class TP9 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p9)

        buttonStart.setOnClickListener(View.OnClickListener {
            FormationService.startService(this, "Foreground Service is running...")
        })
        buttonStop.setOnClickListener(View.OnClickListener {
            FormationService.stopService(this)
        })
    }

    private fun foregroundNotificationBuilder(context: Context): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, context.getString(R.string.app_name))
            .setContentTitle(context.getString(R.string.app_name))
            .setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setColor(ResourcesCompat.getColor(context.resources, R.color.colorPrimary, context.theme))
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
    }
}


