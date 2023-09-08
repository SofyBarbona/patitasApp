package com.example.prueba.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueba.AppDatabase
import com.example.prueba.Codigo
import com.example.prueba.R
import com.example.prueba.adapter.UsuarioAdapter
import com.example.prueba.databinding.ActivityVerListaUsuariosBinding


class VerListaUsuarios : AppCompatActivity() {

    private lateinit var binding: ActivityVerListaUsuariosBinding
    private lateinit var adapter: UsuarioAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerListaUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.usuarios)
        supportActionBar!!.setIcon(R.drawable.loguitito)

        initRecyclerView()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista_usuarios, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_continuar){
            val intentCodigo= Intent(this, Codigo::class.java)
            startActivity(intentCodigo)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        adapter = UsuarioAdapter(
            listaUsuarios = getUsuarios(),
            onClickListener = { usuario -> onItemSelected(usuario)}
        )
        binding.recyclerUsuario.layoutManager = manager
        binding.recyclerUsuario.adapter = adapter
        binding.recyclerUsuario.addItemDecoration(decoration)
    }

    private fun getUsuarios(): MutableList<Usuario> {
        val usuarios: MutableList<Usuario> = ArrayList()
        val bdd = AppDatabase.getDatabase(this)
        usuarios.addAll(bdd.usuarioDao().getAll())
        return usuarios
    }

    private fun onItemSelected(usuario: Usuario){
        Toast.makeText(this,usuario.nombre, Toast.LENGTH_SHORT).show()
    }


}