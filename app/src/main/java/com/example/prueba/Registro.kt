package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.prueba.usuario.Usuario
import com.example.prueba.usuario.VerListaUsuarios

class Registro : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var edReEmail: EditText
    private lateinit var edReContra: EditText
    private lateinit var btnReRegistrarse: Button
    private lateinit var cbAceptar: CheckBox
    private lateinit var tvLeerCondiciones: TextView

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
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val email = edReEmail.text.toString()
            val contra = edReContra.text.toString()

            if(nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contra.isEmpty() ){
                mensaje+=" - Faltan Datos"
            }else{
                mensaje+=" - Datos OK"

                if(cbAceptar.isChecked){
                    mensaje+= "- Acepta los terminos"

                    val nuevoUsuario = Usuario(nombre, apellido, email, contra)
                    AppDatabase.getDatabase(applicationContext).usuarioDao().insertUsuario(nuevoUsuario)

                    val intentListaUsuarios = Intent(this, VerListaUsuarios::class.java)
                    startActivity(intentListaUsuarios)
                    finish()

                }else{
                    mensaje+= "- Debe aceptar los terminos y condiciones"
                }

            }
            Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
        }


    }
}