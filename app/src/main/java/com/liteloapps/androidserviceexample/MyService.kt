package com.liteloapps.androidserviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    init {
        printLog("service is running...")
    }

    override fun onCreate() {
        super.onCreate()
        printLog("onCreate fun: service created ")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val data = intent?.getStringExtra("EXTRAS")
        if(data != null)
            printLog(data)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        printLog("onDestroy fun: Service is killed!")
    }

    fun printLog(message: String) {
        Log.d("MyService", message)
    }

}