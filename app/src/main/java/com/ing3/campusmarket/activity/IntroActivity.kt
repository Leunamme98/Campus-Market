package com.ing3.campusmarket.activity

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ing3.campusmarket.R
import com.ing3.campusmarket.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro)


        // Bouton pour commencer
        val startButton: androidx.appcompat.widget.AppCompatButton = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.startButton)
        startButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Redirection vers la page de connexion
        val textView3: TextView = findViewById<TextView>(R.id.textView3)
        textView3.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Redirection vers la page d'inscription
        val textView4: TextView = findViewById<TextView>(R.id.textView4)
        textView4.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
