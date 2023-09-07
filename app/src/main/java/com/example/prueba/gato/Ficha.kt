package com.example.prueba.gato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.prueba.R

class Ficha : AppCompatActivity() {
    private lateinit var fotoG: ImageView
    private lateinit var nombreG: TextView
    private lateinit var razaG: TextView
    private lateinit var edadG: TextView
    private lateinit var sexoG: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha)

        toolbar = findViewById(R.id.toolbar)

        val bundle = intent.extras
        val foto = bundle?.getString("fotoG")
        val nombre = bundle?.getString("nombreG")
        val raza = bundle?.getString("razaG")
        val edad = bundle?.getString("edadG")
        val sexo = bundle?.getString("sexoG")

        setSupportActionBar(toolbar)
        supportActionBar!!.title = nombre
        supportActionBar!!.setIcon(R.drawable.loguitito)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ficha, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_volver){
            val intentListaGatos = Intent(this, VerLista::class.java)
            startActivity(intentListaGatos)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}