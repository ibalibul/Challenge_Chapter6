package com.iqbal.challenge_chapter6.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbal.challenge_chapter6.model.DataUser
import com.iqbal.challenge_chapter6.model.GetUserResponsItem
import com.iqbal.challenge_chapter6.network.APIServices
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelUser @Inject constructor(var userApi : APIServices) : ViewModel() {

    lateinit var getDataUser : MutableLiveData<List<GetUserResponsItem>?>
    lateinit var postLDUser : MutableLiveData<GetUserResponsItem?>
    lateinit var putLDUser : MutableLiveData<GetUserResponsItem?>
    lateinit var getuser : MutableLiveData<GetUserResponsItem?>

    init {
        getDataUser = MutableLiveData()
        postLDUser = MutableLiveData()
        putLDUser = MutableLiveData()
        getuser = MutableLiveData()
    }

    fun getDataUser() : MutableLiveData<List<GetUserResponsItem>?> {
        return getDataUser
    }

    fun postLiveDataUser() : MutableLiveData<GetUserResponsItem?> {
        return postLDUser
    }

    fun UpdateLiveData() : MutableLiveData<GetUserResponsItem?> {
        return putLDUser
    }

    fun getUserData() : MutableLiveData<GetUserResponsItem?> {
        return getuser
    }

    fun getApiUser(){
        userApi.getAllUser()
            .enqueue(object : Callback<List<GetUserResponsItem>>{
                override fun onResponse(
                    call: Call<List<GetUserResponsItem>>,
                    response: Response<List<GetUserResponsItem>>
                ) {
                    if (response.isSuccessful){
                        getDataUser.postValue(response.body())
                    }else {
                        getDataUser.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetUserResponsItem>>, t: Throwable) {
                    getDataUser.postValue(null)
                }
            })
    }

    fun postApiUser(password : String, username : String) {
        userApi.regiterUser(DataUser(password,username))
            .enqueue(object : Callback<GetUserResponsItem>{
                override fun onResponse(call: Call<GetUserResponsItem>,
                    response: Response<GetUserResponsItem>
                ) {
                    if (response.isSuccessful){
                        postLDUser.postValue(response.body())
                    }else{
                        postLDUser.postValue(null)
                    }
                }

                override fun onFailure(call: Call<GetUserResponsItem>, t: Throwable) {
                    postLDUser.postValue(null)
                }

            })
    }

    fun updateApiUser(id : Int, name : String, password : String, username : String ) {
        userApi.UpdateDatFilm(id,DataUser(password,username))
            .enqueue(object : Callback<GetUserResponsItem>{
                override fun onResponse(
                    call: Call<GetUserResponsItem>,
                    response: Response<GetUserResponsItem>
                ) {
                    if (response.isSuccessful){
                        putLDUser.postValue(response.body())
                    }else{
                        putLDUser.postValue(null)
                    }
                }

                override fun onFailure(call: Call<GetUserResponsItem>, t: Throwable) {
                    putLDUser.postValue(null)
                }

            })
    }
    fun getUserByUsername (name: String, password: String){
        userApi.getUserByUsername(name,password)
            .enqueue(object : Callback<List<GetUserResponsItem>>{
                override fun onResponse(
                    call: Call<List<GetUserResponsItem>>,
                    response: Response<List<GetUserResponsItem>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            val isExsist =  it.find {
                                user -> user.name == name && user.password == password
                            }
                            if (isExsist != null){
                                getuser.postValue(isExsist)
                            }else
                                getuser.postValue(null)
                        }
                    }
                }

                override fun onFailure(call: Call<List<GetUserResponsItem>>, t: Throwable) {
                    getuser.postValue(null)
                }

            })
    }
}