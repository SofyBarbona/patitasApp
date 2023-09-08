package com.example.prueba.refugio

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
import com.example.prueba.gato.VerListaGatos
import com.example.prueba.adapter.RefugioAdapter
import com.example.prueba.databinding.ActivityVerListaRefugiosBinding

class VerListaRefugios : AppCompatActivity() {

    private lateinit var binding: ActivityVerListaRefugiosBinding
    private lateinit var adapter: RefugioAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerListaRefugiosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.refugios)
        supportActionBar!!.setIcon(R.drawable.loguitito)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista_refugios, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_listado){
            val intentListadoGatos = Intent(this, VerListaGatos::class.java)
            startActivity(intentListadoGatos)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        adapter = RefugioAdapter(
            listaRefugios = RefugiosProvider.listaRefugios,
            onClickListener = { refugio -> onItemSelected(refugio)},
            onClickSeleccionado = {position -> onItemInformation(position)}
        )
        binding.recyclerRefugio.layoutManager = manager
        binding.recyclerRefugio.adapter = adapter
        binding.recyclerRefugio.addItemDecoration(decoration)
    }

    private fun onItemInformation(refugio: Refugio){
        val intentFichaRefugio = Intent(this, FichaRefugio::class.java)

        intentFichaRefugio.putExtra("fotoR",refugio.foto)
        intentFichaRefugio.putExtra("nombreR",refugio.nombre)
        intentFichaRefugio.putExtra("direccionR",refugio.direccion)
        intentFichaRefugio.putExtra("redRefugio",refugio.red)

        startActivity(intentFichaRefugio)
    }

    private fun onItemSelected(refugio: Refugio){
        Toast.makeText(this,refugio.nombre, Toast.LENGTH_SHORT).show()
    }
}