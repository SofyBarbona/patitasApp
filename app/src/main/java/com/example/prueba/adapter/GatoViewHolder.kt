package com.example.prueba.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prueba.Gato.Gato
import com.example.prueba.databinding.ItemGatoBinding

class GatoViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemGatoBinding.bind(view)

    fun render(
        gato: Gato,
        onClickListener:(Gato) -> Unit,
        onClickSeleccionado:(Gato) -> Unit
    )
    {
        binding.tvGatoNombre.text = gato.nombre
        Glide.with(binding.ivGato.context).load(gato.foto).into(binding.ivGato)

        itemView.setOnClickListener { onClickListener (gato) }
        binding.btnFicha.setOnClickListener { onClickSeleccionado (gato)}

    }

}