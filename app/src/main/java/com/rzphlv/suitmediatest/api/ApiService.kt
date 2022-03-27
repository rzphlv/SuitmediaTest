package com.rzphlv.suitmediatest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    fun create(): ApiEndpoint{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.steinhq.com/v1/").build()


        return retrofit.create(ApiEndpoint::class.java)
    }
}