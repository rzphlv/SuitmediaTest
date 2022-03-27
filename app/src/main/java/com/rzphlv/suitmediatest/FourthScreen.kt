package com.rzphlv.suitmediatest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rzphlv.suitmediatest.adapter.GuestAdapter
import com.rzphlv.suitmediatest.api.ApiService
import com.rzphlv.suitmediatest.model.Guest
import kotlinx.android.synthetic.main.activity_fourth_screen.*
import kotlinx.android.synthetic.main.activity_third_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FourthScreen : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_screen)
        var userList = ArrayList<Guest>()

        val apiInterface = ApiService.create().data()

        apiInterface.enqueue( object : Callback<List<Guest>>{
            override fun onResponse(call: Call<List<Guest>>?, response: Response<List<Guest>>?) {
                if(response?.body() != null){
                    //userList.addAll(response!!.body()!!)
                    Log.d("yuuuu", response!!.body()!!.toString())
                        val guestAdapter  = GuestAdapter(response!!.body()!!){

                        }
                    Log.d("hhaaa", guestAdapter.toString())
                    /*
                    recycleQuest.apply {
                        layoutManager = GridLayoutManager(this@FourthScreen,2)
                        adapter = guestAdapter
                    }

                     */

                    //Log.d("yuuuu10", userList.toString())
                } else{
                    Log.d("yuuuu1", "kosong")
                }
            }

            override fun onFailure(call: Call<List<Guest>>?, t: Throwable?) {
                Log.d("yuuuu2", "failure")
            }
        })

       // val listGuest = userList

        /*
        val guestAdapter = GuestAdapter(listGuest) { guest ->
            val gs: String = guest.first_name
            val intent = Intent(applicationContext, SecondScreen::class.java)
            intent.putExtra("guest", gs)
            startActivity(intent)
        }

        recycle.apply {
            layoutManager = GridLayoutManager(this@FourthScreen,2)
            adapter = guestAdapter
        }

         */

    }
}