package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun clickTP1(view: View) {
        val intent = Intent(this, TP1::class.java)
        startActivity(intent)
    }

    fun clickTP2(view: View) {
        val intent = Intent(this, TP2::class.java)
        startActivity(intent)
    }

    fun clickTP3(view: View) {
        val intent = Intent(this, TP3::class.java)
        startActivity(intent)
    }

    fun clickTP4(view: View) {
        val intent = Intent(this, TP4::class.java)
        startActivity(intent)
    }

    fun clickTP5(view: View) {
        val intent = Intent(this, TP5::class.java)
        startActivity(intent)
    }

    fun clickTP6(view: View) {
        val intent = Intent(this, TP6::class.java)
        startActivity(intent)
    }

    fun clickTP7(view: View) {
        val intent = Intent(this, TP7::class.java)
        startActivity(intent)
    }

    fun clickTP8(view: View) {
        val intent = Intent(this, TP8::class.java)
        startActivity(intent)
    }

    fun clickTP9(view: View) {
        val intent = Intent(this, TP9::class.java)
        startActivity(intent)
    }
}
