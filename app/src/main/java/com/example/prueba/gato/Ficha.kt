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
import com.example.prueba.Fragmento
import com.example.prueba.FragmentoInterfaz
import com.example.prueba.R
import com.example.prueba.SegundoFragmento

class Ficha : AppCompatActivity(), FragmentoInterfaz {
    private lateinit var fotoG: ImageView
    private lateinit var nombreG: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha)

        toolbar = findViewById(R.id.toolbar)

        val bundle = intent.extras
        val foto = bundle?.getString("fotoG")
        val nombre = bundle?.getString("nombreG")
        val raza = bundle?.getString("razaG")
        val friendly = bundle?.getString("friendlyG")
        val sexo = bundle?.getString("sexoG")


        setSupportActionBar(toolbar)
        supportActionBar!!.title = nombre
        supportActionBar!!.setIcon(R.drawable.loguitito)

        nombreG = findViewById(R.id.txNombre)
        nombreG.text = nombre

        fotoG = findViewById(R.id.txGato)
        Glide.with(fotoG.context).load(foto).into(fotoG)


        //Fragmento
        val primerFragmento = Fragmento()
        val mBundle = Bundle()

        mBundle.putString("raza",raza)
        mBundle.putString("friendly",friendly)
        mBundle.putString("sexo",sexo)

        primerFragmento.arguments = mBundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor_fragmento, primerFragmento)
            .commit()

        supportFragmentManager.findFragmentById(R.id.contenedor_fragmento) as? Fragmento
        primerFragmento?.listener = this
        //Fragmento

        Toast.makeText(this,nombre, Toast.LENGTH_SHORT).show()
    }

    override fun mostrarSegundoFragmento() {
        val bundle = intent.extras
        val atencion = bundle?.getString("atencionNecesariaG")
        val pelo = bundle?.getString("tiraPeloG")
        val amigable = bundle?.getString("amigableConAnimalesG")

        val segundoFragmento = SegundoFragmento()
        val mBundle = Bundle()

        mBundle.putString("atencion",atencion)
        mBundle.putString("pelo",pelo)
        mBundle.putString("amigable",amigable)

        segundoFragmento.arguments = mBundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor_segundo_fragmento, segundoFragmento)
            .addToBackStack(null)
            .commit()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ficha, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_volver){
            val intentListaGatos = Intent(this, VerListaGatos::class.java)
            startActivity(intentListaGatos)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}