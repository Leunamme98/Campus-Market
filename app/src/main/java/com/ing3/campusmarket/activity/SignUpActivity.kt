package com.ing3.campusmarket.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ing3.campusmarket.R
import android.Manifest
import android.app.Activity
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    private lateinit var photoProfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val ajoutImgBtn = findViewById<Button>(R.id.btnAjouterPhoto)
        photoProfil = findViewById<ImageView>(R.id.photoProfil)
        val InscriptionBtn = findViewById<Button>(R.id.btnInscription)

        // Lien pour se rendre sur la page de connexion
        val tvConnexion = findViewById<TextView>(R.id.tvLienConnexion)
        tvConnexion.setOnClickListener {
            // Code pour se rendre sur la page de connexion
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Ajout d'une image
        ajoutImgBtn.setOnClickListener {
            checkPermissionAndOpenGallery()
        }

        // Lien pour se rendre sur la page de connexion
        InscriptionBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun checkPermissionAndOpenGallery() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openGallery()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                openGallery()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(intent)
    }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                var selectedImageUri = data?.data
                photoProfil.setImageURI(selectedImageUri)
            }
        }
}