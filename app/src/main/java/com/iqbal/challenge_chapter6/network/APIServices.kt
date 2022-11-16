package com.iqbal.challenge_chapter6.network

import com.iqbal.challenge_chapter6.model.DataUser
import com.iqbal.challenge_chapter6.model.GetFilmResponsItem
import com.iqbal.challenge_chapter6.model.GetUserRespons
import com.iqbal.challenge_chapter6.model.GetUserResponsItem
import retrofit2.Call
import retrofit2.http.*

interface APIServices {

    @GET("film")
    fun getAllFilm() : Call<List<GetFilmResponsItem>>

    @GET("user")
    fun getAllUser() : Call<List<GetUserResponsItem>>

    @GET("user")
    fun getUserByUsername(@Query("name") name : String,@Query("password")password :String) : Call<List<GetUserResponsItem>>

    @POST("user")
    fun regiterUser(@Body request : DataUser) : Call<GetUserResponsItem>

    @PUT("user/{id}")
    fun UpdateDatFilm(@Path("id") id: Int, @Body reques: DataUser) : Call<GetUserResponsItem>


}