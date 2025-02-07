package com.ing3.campusmarket.activity

import android.content.Intent
import android.os.Bundle

import com.ing3.campusmarket.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bouton pour retourner sur la page d'inscription :
        binding.btnSign.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }



    }
}