package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.prueba.adapter.GatoAdapter
import com.example.prueba.databinding.ActivityVerListaBinding

class Ficha : AppCompatActivity() {
    lateinit var fotoG: ImageView
    lateinit var nombreG: TextView
    lateinit var razaG: TextView
    lateinit var edadG: TextView
    lateinit var sexoG: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha)

        val bundle = intent.extras
        val foto = bundle?.getString("fotoG")
        val nombre = bundle?.getString("nombreG")
        val raza = bundle?.getString("razaG")
        val edad = bundle?.getString("edadG")
        val sexo = bundle?.getString("sexoG")

        nombreG = findViewById(R.id.txNombre)
        nombreG.text = nombre

        razaG = findViewById(R.id.txRaza)
        razaG.text = raza

        edadG = findViewById(R.id.txEdad)
        edadG.text = edad

        sexoG = findViewById(R.id.txSexo)
        sexoG.text = sexo


        fotoG = findViewById(R.id.txGato)
        Glide.with(fotoG.context).load(foto).into(fotoG)

        Toast.makeText(this,nombre, Toast.LENGTH_SHORT).show()

    }

}