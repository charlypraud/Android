package com.example.android

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_t_p8.*
import org.w3c.dom.Text
import kotlin.concurrent.thread

class TP8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p8)

        val demarrer: Button = findViewById(R.id.btn_rebours)
        val txt: TextView = findViewById(R.id.txt_rebours)
        demarrer.setOnClickListener() {
            var compteur = 10
            val thread = Thread {
                while (compteur > -1 ) {
                    this.runOnUiThread() {
                        txt.setText(compteur.toString())
                    }
                    Thread.sleep(1000)
                    compteur -= 1
                }
            }
            thread.start()
        }
    }
}
