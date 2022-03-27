package com.rzphlv.suitmediatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rzphlv.suitmediatest.model.Event
import com.rzphlv.suitmediatest.adapter.EventAdapter
import kotlinx.android.synthetic.main.activity_third_screen.*

class ThirdScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        val listEvent = listOf(
            Event("Google","Google Inc.","20 April 2022", "https://kgo.googleusercontent.com/profile_vrt_raw_bytes_1587515358_10512.png"),
            Event("Twitter","Twitter Inc.","21 April 2022", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Twitter-logo.svg/1200px-Twitter-logo.svg.png"),
            Event("Facebook","Meta Inc.","22 April 2022", "https://www.facebook.com/images/fb_icon_325x325.png"),
            Event("Apple","Apple Inc.","23 April 2022", "https://download.logo.wine/logo/Apple_Inc./Apple_Inc.-Logo.wine.png"),
        )

        val eventAdapter = EventAdapter(listEvent) { event ->
            val ev: String = event.name
            val intent = Intent(applicationContext, SecondScreen::class.java)
            intent.putExtra("event", ev)
            startActivity(intent)
        }

        recycle.apply {
            layoutManager = LinearLayoutManager(this@ThirdScreen)
            adapter = eventAdapter
        }
    }

}