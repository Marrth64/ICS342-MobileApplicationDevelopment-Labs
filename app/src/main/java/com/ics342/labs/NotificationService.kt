package com.ics342.labs

import android.Manifest.permission
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import java.util.UUID

class NotificationService: Service() {

    private val notificationManager: NotificationManagerCompat =
        NotificationManagerCompat.from(this)

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // If permission has not been granted, stop the service and return from
        // onStartCommand
        if (ContextCompat.checkSelfPermission(
                this@NotificationService,
                permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            stopSelf()
            return START_NOT_STICKY
        }

       // Build notification
        var builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.star)
            .setContentTitle("Alert")
            .setContentText("Hello egrfreg")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        TODO("Build and show notification")
        with(notificationManager){
            notify(NOTIFICATION_ID, builder.build())
        }
        return START_STICKY_COMPATIBILITY
    }

    override fun onBind(intent: Intent?): IBinder? {
        // No need to implement for lab 8
        return null
    }

    private fun createNotificationChannel() {
       // TODO("Create notification channel and register with the system")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.0){
            val name = getString(R.string.app_name)
            val desc = getString(R.string.app_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply{
                description = desc
            }
        }
        val notificationManager:NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    companion object {
        private const val CHANNEL_ID = "LAB_7_CHANNEL_ID"
        private const val NOTIFICATION_ID = 1234
    }
}
