package com.example.prueba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragmento : Fragment(){

    var listener: FragmentoInterfaz? = null
    //Declaro las variables del layout
    private lateinit var razaG: TextView
    private lateinit var friendlyG: TextView
    private lateinit var sexoG: TextView
    private lateinit var btnMostrarContenido: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment,container,false)

        //Consigo la info del bundle
        val mBundle = arguments
        val raza = mBundle?.getString("raza")
        val friendly = mBundle?.getString("friendly")
        val sexo = mBundle?.getString("sexo")

        razaG =view.findViewById(R.id.txRaza)
        razaG.text = raza

        friendlyG = view.findViewById(R.id.txFriendly)
        friendlyG.text = friendly

        sexoG = view.findViewById(R.id.txSexo)
        sexoG.text = sexo

        btnMostrarContenido = view.findViewById(R.id.btnFragmento)
        btnMostrarContenido.setOnClickListener {
            listener?.mostrarSegundoFragmento()
        }
        return view
    }
}