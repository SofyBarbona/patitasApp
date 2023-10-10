package com.example.prueba

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.configurations.RetrofitClient
import com.example.prueba.dtos.Images
import com.example.prueba.endpoints.MyApi
import com.example.prueba.gato.Gato
import com.example.prueba.gato.GatosProvider
import retrofit2.Call
import retrofit2.Response

class PRUEBA : AppCompatActivity() {
    private lateinit var tvServicioRest : TextView
    private lateinit var probando : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)

        val api = RetrofitClient.retrofit.create(MyApi::class.java)
        val callPosts = api.getPosts()

        callPosts.enqueue(object : retrofit2.Callback<List<Images>>
        {
            override fun onResponse(call: Call<List<Images>>, response:Response<List<Images>>){
                val images = response.body()
                if(images != null){

                    tvServicioRest = findViewById(R.id.tvServicioRest)
                    tvServicioRest.text = images[0].url

                    probando = findViewById(R.id.tvProbando)
                    probando.text = images.toString()

                    changeList(GatosProvider.listaGatos,images)

                }
            }

            override fun onFailure(call: Call<List<Images>>, t:Throwable){
                Log.e("ERROR", t.message?:"")
            }
        })

    }

    private fun changeList(listaGatos: MutableList<Gato>, listaImages: List<Images>){
        for(i in 0..9){
            listaGatos[i].foto = listaImages[i].url
        }

    }

}