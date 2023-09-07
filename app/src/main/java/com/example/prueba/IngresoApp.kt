package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class IngresoApp : AppCompatActivity() {
    private var demora : Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_app)

        val r = Runnable {
            val intentMainActivity = Intent(this,MainActivity::class.java)
            startActivity(intentMainActivity)
            finish()
        }

        Handler(Looper.getMainLooper()).postDelayed(r,demora)

    }
}