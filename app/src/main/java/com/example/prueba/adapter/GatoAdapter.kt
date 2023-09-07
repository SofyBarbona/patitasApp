package com.example.prueba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.Gato.Gato
import com.example.prueba.R

class GatoAdapter(
    private val listaGatos:List<Gato>,
    private val onClickListener:(Gato) -> Unit,
    private val onClickSeleccionado:(Gato) ->Unit
) : RecyclerView.Adapter<GatoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GatoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GatoViewHolder(layoutInflater.inflate(R.layout.item_gato, parent, false))
    }

    override fun getItemCount(): Int = listaGatos.size

    override fun onBindViewHolder(holder: GatoViewHolder, position: Int) {
        val item = listaGatos[position]
        holder.render(item, onClickListener, onClickSeleccionado)
    }

}