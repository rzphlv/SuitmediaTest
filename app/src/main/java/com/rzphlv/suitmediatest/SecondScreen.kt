package com.rzphlv.suitmediatest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        val name : TextView = findViewById(R.id.txt_name)
        val intent = intent
        val str = intent.getStringExtra("name")
        name.text = str

        val ev : Button = findViewById(R.id.btn_event)
        ev.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, ThirdScreen::class.java)
            startActivity(intent)
        })

        val gs : Button = findViewById(R.id.btn_guest)
        gs.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, FourthScreen::class.java)
            startActivity(intent)
        })

        val eve = intent.getStringExtra("event")
        if (eve != null){
            ev.text = eve
        }

    }
}