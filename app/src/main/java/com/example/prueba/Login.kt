package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.prueba.gato.VerListaGatos
import com.example.prueba.usuario.Usuario

class Login : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etContra: EditText
    private lateinit var btnIniciarSesion: Button
    private lateinit var btnRegistrar: Button
    private lateinit var cbRecordar: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.Email)
        etContra = findViewById(R.id.Contra)
        btnIniciarSesion = findViewById(R.id.IniciarSesion)
        btnRegistrar = findViewById(R.id.Registrarse)
        cbRecordar = findViewById(R.id.RecordarUsuario)

        val preferencias = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
        val usuarioGuardado = preferencias.getString(resources.getString(R.string.nombre_usuario),null)
        val passwordGuardado = preferencias.getString(resources.getString(R.string.password_usuario),null)

        if(usuarioGuardado != null && passwordGuardado != null){
            startMainActivity()
        }

        btnRegistrar.setOnClickListener {
            val intentRegistro = Intent(this, Registro::class.java)
            startActivity(intentRegistro)
            Toast.makeText(this,"Registrar usuario",Toast.LENGTH_SHORT).show()
        }

        btnIniciarSesion.setOnClickListener {
            var mensaje = "Iniciar sesion"
            val nombreUsuario = etEmail.text.toString()
            val passwordUsuario = etContra.text.toString()

            if(nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
                mensaje+= " - Faltan Datos"
            }else{
                val usuarios: MutableList<Usuario> = getUsuarios()
                var check: Int = 0

                for(item in usuarios){
                    if(item.email == nombreUsuario && item.contra == passwordUsuario){
                        mensaje+= " - DATOS CORRECTOS"
                        check = 1
                    }
                    if(item.email == nombreUsuario && item.contra != passwordUsuario){
                        mensaje+= " - CONTRASEÑA INCORRECTA"
                    }
                }

                if(check == 0){
                    mensaje+= " - NO HAY UN USUARIO REGISTRADO CON ESTOS DATOS"
                }

                if(cbRecordar.isChecked){
                    val preferencias2 = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
                    preferencias2.edit().putString(resources.getString(R.string.nombre_usuario),nombreUsuario).apply()
                    preferencias2.edit().putString(resources.getString(R.string.password_usuario), passwordUsuario).apply()

                    mensaje+= " - Recordar Usuario"
                }

                if(check == 1){
                    startMainActivity()
                }

            }
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
        }

    }

    private fun getUsuarios(): MutableList<Usuario> {
        val usuarios: MutableList<Usuario> = ArrayList()
        val bdd = AppDatabase.getDatabase(this)
        usuarios.addAll(bdd.usuarioDao().getAll())
        return usuarios
    }

    private fun startMainActivity() {
        val intentLista = Intent(this, VerListaGatos::class.java)
        startActivity(intentLista)
        finish()
    }
}