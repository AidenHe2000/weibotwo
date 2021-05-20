package com.example.weibo2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

private const val TAG = "LoginActivity"

const val AppKey = "3617242880"
const val AppSecret = "17281b15cf0683046563bc92262ea662"
const val RedirectUri = "https://api.weibo.com/oauth2/default.html"

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
            Log.d(TAG, inputCode)
//            val editor = getSharedPreferences("auth", Context.MODE_PRIVATE).edit()
//            editor.apply {
//                putString("code", inputCode)
//                apply()
//            }
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("code", inputCode)
            startActivity(intent)
        }
    }
}