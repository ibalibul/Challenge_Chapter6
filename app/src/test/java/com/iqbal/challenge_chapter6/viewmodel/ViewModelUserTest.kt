package com.iqbal.challenge_chapter6.viewmodel

import com.iqbal.challenge_chapter6.model.DataUser
import com.iqbal.challenge_chapter6.model.GetUserResponsItem
import com.iqbal.challenge_chapter6.network.APIServices
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class ViewModelUserTest{

    lateinit var services : APIServices

    @Before
    fun setUp() {
        services = mockk()
    }

    @Test
    fun testpostApiUser() {
        val responseDataUser = mockk<Call<GetUserResponsItem>>()
        val dumy = DataUser("password","name")
        every {
            runBlocking {
                services.regiterUser(dumy)
            }
        }returns responseDataUser
        val result =  services.regiterUser(dumy)
        verify {
            runBlocking{
                services.regiterUser(dumy)
            }
        }
        assertEquals(result,responseDataUser)
    }
}