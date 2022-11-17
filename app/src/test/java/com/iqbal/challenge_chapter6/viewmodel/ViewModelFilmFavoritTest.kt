package com.iqbal.challenge_chapter6.viewmodel

import com.iqbal.challenge_chapter6.model.DataFavorite
import com.iqbal.challenge_chapter6.model.GetFavoriteUserItem
import com.iqbal.challenge_chapter6.network.APIServices
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class ViewModelFilmFavoritTest{

    lateinit var services : APIServices


    @Before
    fun setUp(){
        services = mockk()
    }

    @Test
    fun testcallApiFilmFavorit():Unit = runBlocking {
        val respownsDataFavorit = mockk<Call<List<GetFavoriteUserItem>>>()
        every {
            runBlocking {
                services.getallFilmFavorite()
            }
        } returns respownsDataFavorit
        val result = services.getallFilmFavorite()

        verify {
            runBlocking {
                services.getallFilmFavorite()
            }
        }
        assertEquals(result, respownsDataFavorit)
    }

    @Test
    fun  postDataFavorite() :Unit = runBlocking{
        val resposeDataFavorit =  mockk<Call<GetFavoriteUserItem>>()
        val dumy = DataFavorite("id","image","name")
        every {
            runBlocking{
                services.postfilmfavorit(dumy)
            }
        }returns resposeDataFavorit
        val result = services.postfilmfavorit(dumy)

        verify {
            runBlocking{
                services.postfilmfavorit(dumy)
            }
        }
        assertEquals(result, resposeDataFavorit)
    }
}