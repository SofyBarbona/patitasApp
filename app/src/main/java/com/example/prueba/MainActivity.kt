package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.prueba.Gato.VerLista

class MainActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etContra: EditText
    lateinit var btnIniciarSesion: Button
    lateinit var btnRegistrar: Button
    lateinit var cbRecordar: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.Email)
        etContra = findViewById(R.id.Contra)
        btnIniciarSesion = findViewById(R.id.IniciarSesion)
        btnRegistrar = findViewById(R.id.Registrarse)
        cbRecordar = findViewById(R.id.RecordarUsuario)

        btnRegistrar.setOnClickListener {
            val intentRegistro = Intent(this, Registro::class.java)
            startActivity(intentRegistro)
            Toast.makeText(this,"Registrar usuario",Toast.LENGTH_SHORT).show()
        }

        btnIniciarSesion.setOnClickListener {
            var mensaje = "Iniciar sesion"
            val nombreUsuario = etEmail.text.toString()
            if(nombreUsuario.isEmpty() || etContra.text.toString().isEmpty()){
                mensaje+= " - Faltan Datos"
            }else{
                mensaje+= " - Datos OK"
                if(cbRecordar.isChecked){
                    mensaje+= " - Recordar Usuario"
                }
                val intentLista = Intent(this, VerLista::class.java)
                intentLista.putExtra("nombre",nombreUsuario)
                startActivity(intentLista)
                finish()
            }
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
        }

    }
}