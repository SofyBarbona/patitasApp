package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class FichaRefugio : AppCompatActivity() {
    lateinit var fotoR: ImageView
    lateinit var nombreR: TextView
    lateinit var direccionR: TextView
    lateinit var redRefugio: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_refugio)

        val bundle = intent.extras
        val foto = bundle?.getString("fotoR")
        val nombre = bundle?.getString("nombreR")
        val raza = bundle?.getString("direccionR")
        val edad = bundle?.getString("redRefugio")

        nombreR = findViewById(R.id.tfNombre)
        nombreR.text = nombre

        direccionR = findViewById(R.id.tfDireccion)
        direccionR.text = raza

        redRefugio = findViewById(R.id.tfRed)
        redRefugio.text = edad

        fotoR = findViewById(R.id.ifFotoR)
        Glide.with(fotoR.context).load(foto).into(fotoR)

        Toast.makeText(this,nombre, Toast.LENGTH_SHORT).show()

    }
}