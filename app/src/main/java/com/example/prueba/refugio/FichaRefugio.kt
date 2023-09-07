package com.example.prueba.refugio

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

class FichaRefugio : AppCompatActivity() {
    private lateinit var fotoR: ImageView
    private lateinit var nombreR: TextView
    private lateinit var direccionR: TextView
    private lateinit var redRefugio: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_refugio)

        toolbar = findViewById(R.id.toolbar)

        val bundle = intent.extras
        val foto = bundle?.getString("fotoR")
        val nombre = bundle?.getString("nombreR")
        val raza = bundle?.getString("direccionR")
        val edad = bundle?.getString("redRefugio")

        setSupportActionBar(toolbar)
        supportActionBar!!.title = nombre
        supportActionBar!!.setIcon(R.drawable.loguitito)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ficha, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_volver){
            val intentListaRefugios = Intent(this, VerListaRefugios::class.java)
            startActivity(intentListaRefugios)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}