package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat

class IngresoApp : AppCompatActivity() {
    private var demora : Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_app)

        val intentServicio = Intent(this,ServicioMusica::class.java)
        ContextCompat.startForegroundService(this,intentServicio)

        val r = Runnable {
            stopService(intentServicio)
            val intentLogin = Intent(this,Login::class.java)
            startActivity(intentLogin)
            finish()
        }

        Handler(Looper.getMainLooper()).postDelayed(r,demora)

    }
}