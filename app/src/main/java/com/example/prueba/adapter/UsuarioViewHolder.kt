package com.example.prueba.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ItemUsuarioBinding

import com.example.prueba.usuario.Usuario

class UsuarioViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemUsuarioBinding.bind(view)

    fun render(
        usuario: Usuario,
        onClickListener:(Usuario) -> Unit
    )
    {
        binding.tvUsuarioNombre.text = usuario.nombre
        binding.tvUsuarioApellido.text = usuario.apellido
        binding.tvUsuarioEmail.text = usuario.email
        binding.tvUsuarioContra.text = usuario.contra


        itemView.setOnClickListener { onClickListener (usuario) }
    }
}