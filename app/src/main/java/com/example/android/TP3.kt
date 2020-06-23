package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.android.R

class TP3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p3)

        val email = findViewById<EditText>(R.id.edt_mail)
        val mdp = findViewById<EditText>(R.id.edt_mdp)
        val message = findViewById<TextView>(R.id.txv_msg)
        val btn = findViewById<Button>(R.id.btn_connecter)
        btn.setOnClickListener() {
            var info = validate(email.text.toString(), mdp.text.toString())
            message.text = info
        }
    }

    fun validate(email: String, mdp: String): String{
        var message: String
        if (email == "admin" && mdp == "password") {
            message = "Bienvenue, $email !"
            val intent = Intent(this, TP3::class.java)
            startActivity(intent)
        } else {
            message ="Email ou mot de passe incorrect"
        }
        return message
    }
}
