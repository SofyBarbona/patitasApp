package com.example.prueba.adapter

import android.view.View
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.Refugio
import com.example.prueba.databinding.ItemRefugioBinding

class RefugioViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemRefugioBinding.bind(view)

    fun render(
        refugio: Refugio,
        onClickListener:(Refugio) -> Unit,
        onClickSeleccionado:(Refugio) -> Unit
    )
    {
        binding.tvRefugioNombre.text = refugio.nombre
        Glide.with(binding.ivRefugio.context).load(refugio.foto).into(binding.ivRefugio)

        itemView.setOnClickListener { onClickListener (refugio) }
        binding.btnFichaR.setOnClickListener { onClickSeleccionado (refugio)}

    }
}