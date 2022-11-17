package com.iqbal.challenge_chapter6.viewmodel

import com.iqbal.challenge_chapter6.model.GetFilmResponsItem
import com.iqbal.challenge_chapter6.network.APIServices
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class ViewModelFilmTest {

    lateinit var services : APIServices

    @Before
    fun setUp() {
        services = mockk()
    }

    @Test
    fun testcallApifilm(): Unit = runBlocking{
        val responseDataFilm = mockk<Call<List<GetFilmResponsItem>>>()
        every {
            runBlocking {
                services.getAllFilm()
            }
        }returns responseDataFilm
        val result = services.getAllFilm()
        verify {
            runBlocking {
                services.getAllFilm()
            }
        }
        assertEquals(result,responseDataFilm)
    }


}