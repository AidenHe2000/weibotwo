package com.example.weibo2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.example.weibo2.api.RetrofitCreator
import com.example.weibo2.api.oauth2.AccessToken
import com.example.weibo2.api.oauth2.AuthorizeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "LoginActivity"

private const val AppKey = "3617242880"
private const val AppSecret = "17281b15cf0683046563bc92262ea662"
private const val RedirectUri = "https://api.weibo.com/oauth2/default.html"

class LoginActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var login: Button
    private lateinit var codeInputText: EditText
    private lateinit var confirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        toolbar = findViewById(R.id.toolbar)
        login = findViewById(R.id.login)
        codeInputText = findViewById(R.id.codeInputText)
        confirm = findViewById(R.id.confirm)

        setSupportActionBar(toolbar)

        login.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data =
                Uri.parse("https://open.weibo.cn/oauth2/authorize?client_id=${AppKey}&redirect_uri=${RedirectUri}&display=mobile")
            startActivity(intent)
        }

        confirm.setOnClickListener {
            val inputCode = codeInputText.text.toString()
            Log.d(TAG, "input code: ${inputCode}")
            getAccessToken(inputCode)
        }
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

                val loginSharedPreferences: SharedPreferences =
                    getSharedPreferences("AccessToken", Context.MODE_PRIVATE)
                loginSharedPreferences.edit().apply {
                    putString("access_token", accessToken.access_token)
                    putString("expires_in", accessToken.expires_in)
                    putString("remind_in", accessToken.remind_in)
                    putString("uid", accessToken.uid)
                    apply()
                }
                startActivity(Intent(this@LoginActivity, WeiboStreamActivity::class.java))
            }

            override fun onFailure(call: Call<AccessToken>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}