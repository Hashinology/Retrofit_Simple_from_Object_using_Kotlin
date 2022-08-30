package com.hashinology.retrofitfromobjectusingkotlin.remote

import com.hashinology.retrofitfromobjectusingkotlin.models.MyDataPost
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/posts/"
    }
    @GET(BASE_URL)
    fun getPost(): Call<MyDataPost>
}