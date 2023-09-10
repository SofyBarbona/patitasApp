package com.example.prueba
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Codigo : AppCompatActivity() {
    private lateinit var btnCoContinuar: Button
    private lateinit var numeroUno: EditText
    private lateinit var numeroDos: EditText
    private lateinit var numeroTres: EditText
    private lateinit var numeroCuatro: EditText
    private lateinit var numeroCinco: EditText


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo)


        btnCoContinuar=findViewById(R.id.coContinuar)
        numeroUno=findViewById(R.id.coNumero1)
        numeroDos=findViewById(R.id.coNumero2)
        numeroTres=findViewById(R.id.coNumero3)
        numeroCuatro=findViewById(R.id.coNumero4)
        numeroCinco=findViewById(R.id.coNumero5)

        btnCoContinuar.setOnClickListener{
            val numeroUno=numeroUno.text.toString()
            val numeroDos= numeroDos.text.toString()
            val numeroTres= numeroTres.text.toString()

            val numeroCuatro= numeroCuatro.text.toString()
            val numeroCinco=numeroCinco.text.toString()
            var mensaje="Usuario registrado"

            if(numeroUno.isEmpty()||numeroCuatro.isEmpty()||numeroCinco.isEmpty()||numeroTres.isEmpty()||numeroDos.isEmpty()){
                mensaje+=" - ERROR FALTAN CAMPOS"
            }else {
                mensaje+= " - Datos correctos"

                startMainActivity()
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()

        }

    }



private fun startMainActivity() {
    val intentLogin = Intent(this, Login:: class.java)
    startActivity(intentLogin)

}


}
