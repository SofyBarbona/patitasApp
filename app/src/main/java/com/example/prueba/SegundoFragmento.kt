package com.example.prueba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SegundoFragmento: Fragment(){

    private lateinit var atencionNecesariaG: TextView
    private lateinit var tiraPeloG: TextView
    private lateinit var amigableConAnimalesG: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.segundo_fragmento,container,false)

        val mBundle = arguments
        val atencion = mBundle?.getString("atencion")
        val pelo = mBundle?.getString("pelo")
        val amigable = mBundle?.getString("amigable")

        atencionNecesariaG =view.findViewById(R.id.txAtencion)
        atencionNecesariaG.text = atencion

        tiraPeloG = view.findViewById(R.id.txTiraPelo)
        tiraPeloG.text = pelo

        amigableConAnimalesG = view.findViewById(R.id.txAmigable)
        amigableConAnimalesG.text = amigable

        return view
    }
}