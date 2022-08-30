package com.hashinology.retrofitfromobjectusingkotlin.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    val instance: RetrofitClient? = null
    var apiInterface: ApiInterface? = null

    init {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiInterface.BASE_URL).build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }
    fun getRetrofitInstance():RetrofitClient{
        if (instance == null){
            return RetrofitClient()
        }else{
            return instance
        }
    }
}