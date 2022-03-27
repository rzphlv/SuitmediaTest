package com.rzphlv.suitmediatest.model

import com.google.gson.annotations.SerializedName

data class Guest(
    @SerializedName("first_name")
    val first_name: String,

    @SerializedName("avatar")
    val avatar: String
)
/*
data class Guest(
    @SerializedName("id")
    val id: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("first_name")
    val first_name: String,

    @SerializedName("last_name")
    val last_name: String,

    @SerializedName("avatar")
    val avatar: String
) */
