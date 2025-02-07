package com.ing3.campusmarket.activity

import android.os.Bundle
import android.content.Intent
import com.ing3.campusmarket.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {

    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bouton pour commencer
        binding.startButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Empêche de revenir à l'écran d'intro
        }

        // Redirection vers la page de connexion
        binding.textView3.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Redirection vers la page d'inscription
        binding.textView4.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
