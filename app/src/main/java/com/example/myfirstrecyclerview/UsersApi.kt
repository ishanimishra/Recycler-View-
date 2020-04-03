package com.example.myfirstrecyclerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.github.com/"

interface UsersApi {
    @GET("repositories?since=5")
    fun getUsers() : Call<List<UserDetails>>

    companion object {
        operator fun invoke() : UsersApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UsersApi::class.java)


        }
    }
}