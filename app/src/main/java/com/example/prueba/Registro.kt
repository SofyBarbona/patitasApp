package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Registro : AppCompatActivity() {
    lateinit var etNombre: EditText
    lateinit var etApellido: EditText
    lateinit var edReEmail: EditText
    lateinit var edReContra: EditText
    lateinit var btnReRegistrarse: Button
    lateinit var cbAceptar: CheckBox
    lateinit var tvLeerCondiciones: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        etNombre = findViewById(R.id.reNombre)
        etApellido = findViewById(R.id.reApellido)
        edReEmail = findViewById(R.id.reEmail)
        edReContra = findViewById(R.id.reContra)
        btnReRegistrarse = findViewById(R.id.reRegistrarse)
        cbAceptar = findViewById(R.id.reAceptar)
        tvLeerCondiciones = findViewById(R.id.reLeerCondiciones)


        tvLeerCondiciones.setOnClickListener {
            val intentCondiciones = Intent(this, TerminosYCondiciones::class.java)
            startActivity(intentCondiciones)
        }

        btnReRegistrarse.setOnClickListener {
            var mensaje = "Registrarse"
            if(etNombre.text.toString().isEmpty() || etApellido.text.toString().isEmpty() ||
                edReEmail.text.toString().isEmpty() || edReContra.text.toString().isEmpty()){
                mensaje+=" - Faltan Datos"
            }else{
                mensaje+=" - Datos OK"
                if(cbAceptar.isChecked){
                    mensaje+= "- Acepta los terminos"
                    val intentCodigo = Intent(this, Codigo::class.java)
                    startActivity(intentCodigo)
                }else{
                    mensaje+= "- Debe aceptar los terminos y condiciones"
                }

            }
            Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
        }


    }
}