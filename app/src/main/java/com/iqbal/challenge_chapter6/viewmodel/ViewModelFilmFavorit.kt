package com.iqbal.challenge_chapter6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbal.challenge_chapter6.model.GetFavoriteUserItem
import com.iqbal.challenge_chapter6.network.APIinterfaceFavorit
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject



class ViewModelFilmFavorit (var apiF : APIinterfaceFavorit) : ViewModel() {

//    lateinit var liveDataFilmFavorit : MutableLiveData<List<GetFavoriteUserItem>?>
//
//    init {
//        liveDataFilmFavorit =  MutableLiveData()
//    }
//
//    fun getliveDataFavorit() : MutableLiveData<List<GetFavoriteUserItem>?> {
//        return liveDataFilmFavorit
//    }
//
//    fun callApiFilmFavorit(){
//        apiF.getallFilmFavorite()
//            .enqueue(object : Callback<List<GetFavoriteUserItem>>{
//                override fun onResponse(
//                    call: Call<List<GetFavoriteUserItem>>,
//                    response: Response<List<GetFavoriteUserItem>>
//                ) {
//                    if (response.isSuccessful) {
//                        liveDataFilmFavorit.postValue(response.body())
//                    }else{
//                        liveDataFilmFavorit.postValue(null)
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetFavoriteUserItem>>, t: Throwable) {
//                    liveDataFilmFavorit.postValue(null)
//                }
//
//            })
//    }
}