package com.example.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class TP1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p1)

        val email = findViewById<EditText>(R.id.edt_mail)
        val mdp = findViewById<EditText>(R.id.edt_mdp)
        val message = findViewById<TextView>(R.id.txv_msg)
        val btn = findViewById<Button>(R.id.btn_connecter)
        btn.setOnClickListener() {
            var info = validate(email.text.toString(), mdp.text.toString())
            //message.text = info

            val toast: Toast = Toast.makeText(applicationContext, info, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM, toast.xOffset , toast.yOffset )
            toast.show()

        }


    }
    fun validate(email: String, mdp: String): String{
        var message = if (email == "admin" && mdp == "password") "Bienvenue, $email !" else "Email ou mot de passe incorrect"
        return message
    }
}
