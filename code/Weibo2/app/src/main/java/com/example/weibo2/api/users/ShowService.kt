package com.example.weibo2.api.users

import com.example.weibo2.api.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShowService {
    @GET("users/show.json")
    fun getShow(
        @Query("access_token") access_token: String
    ): Call<User>

}