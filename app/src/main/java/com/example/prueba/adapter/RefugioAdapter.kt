package com.example.prueba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.R
import com.example.prueba.Refugio

class RefugioAdapter(
    private val listaRefugios:List<Refugio>,
    private val onClickListener:(Refugio) -> Unit,
    private val onClickSeleccionado:(Refugio) ->Unit
    ) : RecyclerView.Adapter<RefugioViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RefugioViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return RefugioViewHolder(layoutInflater.inflate(R.layout.item_refugio, parent, false))
        }

        override fun getItemCount(): Int = listaRefugios.size

        override fun onBindViewHolder(holder: RefugioViewHolder, position: Int) {
            val item = listaRefugios[position]
            holder.render(item, onClickListener, onClickSeleccionado)
        }
}
