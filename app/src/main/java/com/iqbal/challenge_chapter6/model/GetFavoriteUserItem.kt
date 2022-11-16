package com.iqbal.challenge_chapter6.model


import com.google.gson.annotations.SerializedName

data class GetFavoriteUserItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)