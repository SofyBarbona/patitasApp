package com.example.prueba.servicios
import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.prueba.R

class ServicioMusica : Service() {

    private var mediaPlayer: MediaPlayer? = null

    // notificaciones
    private val CHANNEL_ID: String = "Musica"
    //

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    //notificaciones
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificacion = crearNotificacion()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            crearChanelId()
            startForeground(1,notificacion)
        }else{
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details
            }else{
                NotificationManagerCompat.from(this).notify(1, notificacion)
            }
        }

        configurarMediaPlayer()
        mediaPlayer?.start()

        return START_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun crearChanelId() {
        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(CHANNEL_ID,"Servicio de Musica", importance)
        channel.description = "Se mostrara al reproducir musica"
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun crearNotificacion(): Notification {
        return NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Reproduciendo Musica")
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setSmallIcon(R.drawable.logopatitas)
            .build()
    }

    //
    private fun configurarMediaPlayer(){
        mediaPlayer = MediaPlayer.create(this, R.raw.musica)
        mediaPlayer?.setOnCompletionListener {
            stop()
        }
    }

    private fun stop(){
        stopNotificacion()
        stopSelf()
    }

    private fun stopNotificacion(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            NotificationManagerCompat.from(this).cancel(1)
        }
    }

    override fun onDestroy(){
        stop()
        super.onDestroy()
    }


}