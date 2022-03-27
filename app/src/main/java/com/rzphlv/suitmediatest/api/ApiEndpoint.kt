package com.rzphlv.suitmediatest.api

import com.rzphlv.suitmediatest.model.Guest
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("storages/623dcdb3bca21f053e85685d/users")
    fun data(): Call<List<Guest>>
}