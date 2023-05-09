package com.example.mobileassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    var pauseAt:Long=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart : Button=findViewById(R.id.sleep_btnStart)
        val btnStop : Button=findViewById(R.id.sleep_btnStop)
        val btnReset : Button=findViewById(R.id.sleep_btnReset)
        val txtTime : Chronometer=findViewById(R.id.sleep_txtTime)
        val targetTxt: TextView = findViewById(R.id.sleep_target_txt)

        btnStop.isInvisible=true
        btnReset.isInvisible=true

        btnStart.setOnClickListener(){
            txtTime.base=SystemClock.elapsedRealtime()-pauseAt
            txtTime.start()
            btnStart.isInvisible=true
            btnStop.isVisible=true


        }
        btnStop.setOnClickListener(){
            pauseAt = SystemClock.elapsedRealtime() - txtTime.base
            txtTime.stop()
            btnStop.isInvisible=true
            btnReset.isVisible=true

        }
        btnReset.setOnClickListener(){
            txtTime.base=SystemClock.elapsedRealtime()
            pauseAt = 0
            btnReset.isInvisible=true
            btnStart.isVisible=true

        }

    }


}