package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.prueba.configurations.RetrofitClient
import com.example.prueba.dtos.Images
import com.example.prueba.endpoints.MyApi
import com.example.prueba.gato.Gato
import com.example.prueba.gato.GatosProvider
import com.example.prueba.servicios.ServicioMusica
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngresoApp : AppCompatActivity() {
    private var demora : Long = 1600

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_app)

        val intentServicio = Intent(this, ServicioMusica::class.java)
        ContextCompat.startForegroundService(this,intentServicio)

        conectarApi()

        val r = Runnable {
            stopService(intentServicio)
            val intentLogin = Intent(this,Login::class.java)
            startActivity(intentLogin)
            finish()
        }

        Handler(Looper.getMainLooper()).postDelayed(r,demora)

    }

    private fun conectarApi() {
        lifecycleScope.launch {
            val api = RetrofitClient.retrofit.create(MyApi::class.java)
            val callPosts = api.getPosts()

            withContext(Dispatchers.IO) {
                callPosts.enqueue(object : Callback<List<Images>>
                {
                    override fun onResponse(call: Call<List<Images>>, response: Response<List<Images>>){
                        val images = response.body()
                        if(images != null){
                            changeList(GatosProvider.listaGatos,images)
                        }
                    }

                    override fun onFailure(call: Call<List<Images>>, t:Throwable){
                        Log.e("ERROR", t.message?:"")
                    }
                })
            }

        }
    }

    private fun changeList(listaGatos: MutableList<Gato>, listaImages: List<Images>){
        for(i in 0..15){
            listaGatos[i].foto = listaImages[i].image_link
            listaGatos[i].raza = listaImages[i].name
            listaGatos[i].amigableConHumanos = listaImages[i].family_friendly
            listaGatos[i].atencionNecesaria = listaImages[i].grooming
            listaGatos[i].tiraPelo = listaImages[i].shedding
            listaGatos[i].amigableConAnimales = listaImages[i].other_pets_friendly

        }
    }

}