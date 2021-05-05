package com.example.weibo2.api.oauth2

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthorizeService {

    @POST("oauth2/access_token")
    fun getAccessToken(
        @Query("client_id") clientId: String,
        @Query("client_secret") client_secret: String,
        @Query("grant_type") grant_type: String = "authorization_code",
        @Query("code") code: String,
        @Query("redirect_uri") redirect_uri: String
    ): Call<AccessToken>

}