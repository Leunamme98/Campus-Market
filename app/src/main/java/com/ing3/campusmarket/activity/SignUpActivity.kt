package com.ing3.campusmarket.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ing3.campusmarket.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)


        // Lien pour se rendre sur la page de connexion
        val tvConnexion = findViewById<TextView>(R.id.tvLienConnexion)
        tvConnexion.setOnClickListener {
            // Code pour se rendre sur la page de connexion
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}