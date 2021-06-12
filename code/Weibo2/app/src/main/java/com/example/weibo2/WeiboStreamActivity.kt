package com.example.weibo2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textservice.TextInfo
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class WeiboStreamActivity : AppCompatActivity() {

    private val weiboList = ArrayList<WeiboItem>()
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
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        initData() // 初始化数据

        val adapter = WeiboAdapter(weiboList)
        recyclerView.adapter = adapter

    }

    private fun initData() {
        weiboList.add(WeiboItem(R.drawable.head,"Trevan","6月6日", "上海",
            "用RecyclerView实现微博主界面", R.drawable.head, "12","0", "3"))
        weiboList.add(WeiboItem(R.drawable.head1,"Aiden","6月5日", "上海",
            "用RecyclerView实现微博主界面", R.drawable.head1, "23","5", "4"))
        weiboList.add(WeiboItem(R.drawable.head2,"Feiilla","6月4日", "上海",
            "用RecyclerView实现微博主界面", R.drawable.head2, "8","23", "7"))
        weiboList.add(WeiboItem(R.drawable.head3,"Xutao","6月3日", "上海",
            "用RecyclerView实现微博主界面", R.drawable.head3, "12","9", "3"))
        weiboList.add(WeiboItem(R.drawable.head4,"Orson","6月2日", "上海",
            "用RecyclerView实现微博主界面", R.drawable.head4, "43","13", "3"))
        weiboList.add(WeiboItem(R.drawable.head5,"zzh","6月1日", "上海",
            "用RecyclerView实现微博主界面", R.drawable.head5, "12","0", "3"))
    }

}

class WeiboItem(val userPicId: Int, val userName: String, val time: String, val from: String,
                val text: String, val imageId: Int,
                val like: String, val share: String, val comments: String)

/*class WeiboItem(val imageId: Int)*/

class WeiboAdapter(val weiboList: List<WeiboItem>) :
    RecyclerView.Adapter<WeiboAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val userPic: ImageView = view.findViewById(R.id.userPic)
        val userName: TextView = view.findViewById(R.id.userName)
        val time: TextView = view.findViewById(R.id.time)
        val from: TextView = view.findViewById(R.id.from)
        val text: TextView = view.findViewById(R.id.text)
        val img: ImageView = view.findViewById(R.id.Image)
        val like: TextView = view.findViewById(R.id.like)
        val share: TextView = view.findViewById(R.id.share)
        val comments: TextView = view.findViewById(R.id.comment)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weibo_item, parent, false)

        val viewHolder = ViewHolder(view)

        viewHolder.userPic.setOnClickListener {
            val position = viewHolder.adapterPosition
            val weibo = weiboList[position]
            Toast.makeText(parent.context, "you clicked userPic",
                Toast.LENGTH_SHORT).show()
        }

        viewHolder.userName.setOnClickListener {
            val position = viewHolder.adapterPosition
            val weibo = weiboList[position]
            Toast.makeText(parent.context, "you clicked userNmae",
                Toast.LENGTH_SHORT).show()
        }

        viewHolder.text.setOnClickListener {
            val position = viewHolder.adapterPosition
            val weibo = weiboList[position]
            Toast.makeText(parent.context, "you clicked textContent",
                Toast.LENGTH_SHORT).show()
        }

        viewHolder.img.setOnClickListener {
            val position = viewHolder.adapterPosition
            val weibo = weiboList[position]
            Toast.makeText(parent.context, "you clicked img",
                Toast.LENGTH_SHORT).show()
        }

        viewHolder.like.setOnClickListener {
            val position = viewHolder.adapterPosition
            val weibo = weiboList[position]
            Toast.makeText(parent.context, "you clicked like",
                Toast.LENGTH_SHORT).show()
        }

        viewHolder.share.setOnClickListener {
            val position = viewHolder.adapterPosition
            val weibo = weiboList[position]
            Toast.makeText(parent.context, "you clicked share",
                Toast.LENGTH_SHORT).show()
        }

        viewHolder.comments.setOnClickListener {
            val position = viewHolder.adapterPosition
            val weibo = weiboList[position]
            Toast.makeText(parent.context, "you clicked comment",
                Toast.LENGTH_SHORT).show()
        }

        return viewHolder
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weibo = weiboList[position]
        holder.userPic.setImageResource(weibo.userPicId)
        holder.userName.text = weibo.userName
        holder.time.text = weibo.time
        holder.from.text = weibo.from
        holder.text.text = weibo.text
        holder.like.text = weibo.like
        holder.share.text = weibo.share
        holder.comments.text = weibo.comments
        holder.img.setImageResource(weibo.imageId)
    }
    override fun getItemCount() = weiboList.size
}