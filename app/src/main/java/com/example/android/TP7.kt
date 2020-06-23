package com.example.android

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TP7 : AppCompatActivity() {



    private val powerBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val icon: ImageView = findViewById(R.id.imageView)
            val l = intent!!.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            when(l) {
                BatteryManager.BATTERY_PLUGGED_USB -> {
                    icon.setImageResource(R.drawable.ic_battery_charging_full_black_24dp)
                }
                BatteryManager.BATTERY_PLUGGED_AC -> {
                    icon.setImageResource(R.drawable.ic_battery_charging_full_black_24dp)
                }
                BatteryManager.BATTERY_PLUGGED_WIRELESS -> {
                    icon.setImageResource(R.drawable.ic_battery_charging_full_black_24dp)
                }
                else -> icon.setImageResource(R.drawable.ic_battery_full_black_24dp)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p7)

        val batterie = powerBroadcastReceiver
        this.registerReceiver(batterie,  IntentFilter(Intent.ACTION_BATTERY_CHANGED))

    }
}


