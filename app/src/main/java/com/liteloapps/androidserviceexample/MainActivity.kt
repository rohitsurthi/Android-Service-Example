package com.liteloapps.androidserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceInfoText = findViewById<TextView>(R.id.service_info_text)
        val startServiceBtn = findViewById<Button>(R.id.start_service_btn)
        val stopServiceBtn = findViewById<Button>(R.id.stop_service_btn)
        val sendDataBtn = findViewById<Button>(R.id.send_data_btn)
        val textData = findViewById<EditText>(R.id.text_data)

        startServiceBtn.setOnClickListener {
            serviceInfoText.text = "Service running..."
            Intent(this,MyService::class.java).also { myService ->
                startService(myService)
            }
        }

        stopServiceBtn.setOnClickListener {
            serviceInfoText.text = "Service Stopped..."
            Intent(this,MyService::class.java).also { myService ->
                stopService(myService)
            }
        }

        sendDataBtn.setOnClickListener {
            Intent(this,MyService::class.java).also { myService ->
                myService.putExtra("EXTRAS", textData.text.toString())
                startService(myService)
            }
        }

    }
}