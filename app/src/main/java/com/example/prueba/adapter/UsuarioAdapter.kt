package com.example.prueba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.R
import com.example.prueba.usuario.Usuario

class UsuarioAdapter (
    private val listaUsuarios:List<Usuario>,
    private val onClickListener:(Usuario) -> Unit
    ) : RecyclerView.Adapter<UsuarioViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return UsuarioViewHolder(layoutInflater.inflate(R.layout.item_usuario, parent, false))
        }

        override fun getItemCount(): Int = listaUsuarios.size

        override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
            val item = listaUsuarios[position]
            holder.render(item, onClickListener)
        }
    }
