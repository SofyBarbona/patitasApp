package com.example.prueba.configurations

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.prueba.usuario.Usuario
import com.example.prueba.usuario.UsuarioDao

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    companion object{

        private var INSTANCIA: AppDatabase? = null

        fun getDatabase(contexto: Context) : AppDatabase {
            if(INSTANCIA == null){
                synchronized(this){
                    INSTANCIA = Room.databaseBuilder(
                        contexto, AppDatabase::class.java, "base_app_usuarios")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCIA!!
        }



    }

}