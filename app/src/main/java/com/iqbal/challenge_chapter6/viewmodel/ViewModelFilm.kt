package com.iqbal.challenge_chapter6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbal.challenge_chapter6.model.GetFilmResponsItem
import com.iqbal.challenge_chapter6.network.APIClient
import com.iqbal.challenge_chapter6.network.APIServices
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelFilm @Inject constructor(var api : APIServices) : ViewModel() {

    lateinit var liveDataFilm : MutableLiveData<List<GetFilmResponsItem>?>


    init {
        liveDataFilm = MutableLiveData()
    }

    fun getLiveDatafilm() : MutableLiveData<List<GetFilmResponsItem>?> {
        return liveDataFilm
    }

    fun callApifilm() {
       api.getAllFilm()
            .enqueue(object : Callback<List<GetFilmResponsItem>>{
                override fun onResponse(
                    call: Call<List<GetFilmResponsItem>>,
                    response: Response<List<GetFilmResponsItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataFilm.postValue(response.body())

                    }else{
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetFilmResponsItem>>, t: Throwable) {
                    liveDataFilm.postValue(null)
                }

            })
    }
}
