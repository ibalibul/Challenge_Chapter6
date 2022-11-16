package com.iqbal.challenge_chapter6.model


import com.google.gson.annotations.SerializedName

data class GetUserResponsItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)