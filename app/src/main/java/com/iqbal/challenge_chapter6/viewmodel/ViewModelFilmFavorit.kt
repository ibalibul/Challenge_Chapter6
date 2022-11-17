package com.iqbal.challenge_chapter6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbal.challenge_chapter6.model.DataFavorite
import com.iqbal.challenge_chapter6.model.GetFavoriteUserItem
import com.iqbal.challenge_chapter6.network.APIClient
import com.iqbal.challenge_chapter6.network.APIServices
import com.iqbal.challenge_chapter6.network.APIinterfaceFavorit
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ViewModelFilmFavorit @Inject constructor (var apiF : APIServices) : ViewModel() {

    lateinit var postDataFavorit : MutableLiveData<GetFavoriteUserItem?>
    lateinit var liveDataFilmFavorit : MutableLiveData<List<GetFavoriteUserItem>?>

    init {
        liveDataFilmFavorit =  MutableLiveData()
        postDataFavorit =  MutableLiveData()
    }

    fun getliveDataFavorit() : MutableLiveData<List<GetFavoriteUserItem>?> {
        return liveDataFilmFavorit
    }

    fun postDataFavorit() : MutableLiveData<GetFavoriteUserItem?> {
        return postDataFavorit
    }


    fun postDataFavorite(Favorite : DataFavorite) {
        apiF.postfilmfavorit(Favorite)
            .enqueue(object : Callback<GetFavoriteUserItem>{
                override fun onResponse(
                    call: Call<GetFavoriteUserItem>,
                    response: Response<GetFavoriteUserItem>
                ) {
                    if (response.isSuccessful){
                        postDataFavorit.postValue(response.body())
                    }else{
                        postDataFavorit.postValue(null)
                    }
                }

                override fun onFailure(call: Call<GetFavoriteUserItem>, t: Throwable) {
                    postDataFavorit.postValue(null)
                }

            })
    }


    fun callApiFilmFavorit(){
        apiF.getallFilmFavorite()
            .enqueue(object : Callback<List<GetFavoriteUserItem>>{
                override fun onResponse(
                    call: Call<List<GetFavoriteUserItem>>,
                    response: Response<List<GetFavoriteUserItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataFilmFavorit.postValue(response.body())
                    }else{
                        liveDataFilmFavorit.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetFavoriteUserItem>>, t: Throwable) {
                    liveDataFilmFavorit.postValue(null)
                }

            })
    }
}