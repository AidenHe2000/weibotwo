package com.example.weibo2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weibo2.api.RetrofitCreator
import com.example.weibo2.api.oauth2.AccessToken
import com.example.weibo2.api.oauth2.AuthorizeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 获取access_token
        val code = intent.getStringExtra("code") ?: ""
        Log.d(TAG, code)
        getAccessToken(code)
    }

    private fun getAccessToken(code: String) {
        val authorizeService = RetrofitCreator.create(AuthorizeService::class.java)
        authorizeService.getAccessToken(
            clientId = AppKey,
            client_secret = AppSecret,
            code = code,
            redirect_uri = RedirectUri
        ).enqueue(object : Callback<AccessToken> {
            override fun onResponse(call: Call<AccessToken>, response: Response<AccessToken>) {
                val accessToken = response.body() as AccessToken
                Log.d("getAccessToken", accessToken.access_token)
                Log.d("getAccessToken", accessToken.expires_in)
                Log.d("getAccessToken", accessToken.remind_in)
                Log.d("getAccessToken", accessToken.uid)
                //持久化
                getSharedPreferences("AccessToken", Context.MODE_PRIVATE).edit().apply {
                    putString("access_token", accessToken.access_token)
                    putString("expires_in", accessToken.expires_in)
                    putString("remind_in", accessToken.remind_in)
                    putString("uid", accessToken.uid)
                    apply()
                }
            }

            override fun onFailure(call: Call<AccessToken>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}