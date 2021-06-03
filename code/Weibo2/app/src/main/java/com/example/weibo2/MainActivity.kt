package com.example.weibo2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 判断是否已经登陆
        val loginSharedPreferences: SharedPreferences =
            getSharedPreferences("AccessToken", Context.MODE_PRIVATE)
        // 获取accessToken
        val accessToken: String? = loginSharedPreferences.getString("access_token", null)
        if (accessToken == null) {
            Log.d(TAG, "not login in yet")
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        } else Log.d(TAG, "already login in")

    }

}