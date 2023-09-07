package com.example.prueba.Gato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueba.R
import com.example.prueba.Refugio.VerListaRefugios
import com.example.prueba.adapter.GatoAdapter
import com.example.prueba.databinding.ActivityVerListaBinding

class VerLista : AppCompatActivity() {

    private lateinit var binding: ActivityVerListaBinding
    private lateinit var adapter: GatoAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.gatitos)
        supportActionBar!!.setIcon(R.drawable.loguitito)


        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_listado_Refugios){
            val intentListadoRefugio = Intent(this, VerListaRefugios::class.java)
            startActivity(intentListadoRefugio)
        }

        return super.onOptionsItemSelected(item)
    }


    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        adapter = GatoAdapter(
            listaGatos = GatosProvider.listaGatos,
            onClickListener = { gato -> onItemSelected(gato)},
            onClickSeleccionado = {position -> onItemInformation(position)}
            )
        binding.recyclerGato.layoutManager = manager
        binding.recyclerGato.adapter = adapter
        binding.recyclerGato.addItemDecoration(decoration)
    }
    private fun onItemInformation(gato: Gato){
        val intentFicha = Intent(this, Ficha::class.java)
        intentFicha.putExtra("fotoG",gato.foto)
        intentFicha.putExtra("nombreG",gato.nombre)
        intentFicha.putExtra("razaG",gato.raza)
        intentFicha.putExtra("edadG",gato.edad.toString())
        intentFicha.putExtra("sexoG",gato.sexo)
        startActivity(intentFicha)
    }

    private fun onItemSelected(gato: Gato){
        Toast.makeText(this,gato.nombre, Toast.LENGTH_SHORT).show()
    }

}