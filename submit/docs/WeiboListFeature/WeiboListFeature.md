# WeiboListUI

> 该feature实现了微博的滚动效果

#### 技术使用

+ androidx库控件RecyclerView

+ androidx库控件CardView

#### 实现细节

+ 使用CardView布局实现微博子项布局

~~~
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:card_view="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    card_view:cardBackgroundColor="@color/white"
    card_view:cardCornerRadius="2dp"
    card_view:cardElevation="3dp"
    android:layout_marginTop="10dp"
    android:layout_marginLeft="5dp"
    android:layout_marginRight="5dp"
    android:layout_marginBottom="10dp"
    android:clickable="true">

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="10dp"
        android:layout_marginBottom="5dp">

        <ImageView
            android:id="@+id/userPic"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:src="@drawable/head"/>

        <TextView
            android:id="@+id/userName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_toRightOf="@id/userPic"
            android:layout_marginLeft="5dp"
            android:textSize="18sp"
            android:textColor="@color/black"
            android:text="Trevan"/>

        <TextView
            android:id="@+id/time"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/userName"
            android:layout_alignLeft="@id/userName"
            android:layout_marginTop="7dp"
            android:textSize="12sp"
            android:textColor="@color/text__gray_dark"
            android:text="6月6日"/>


        <TextView
            android:id="@+id/from"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_toRightOf="@id/time"
            android:layout_alignTop="@id/time"
            android:layout_marginLeft="5dp"
            android:textSize="12sp"
            android:textColor="@color/text__gray_dark"
            android:text="来自 上海"/>

        <TextView
            android:id="@+id/text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/time"
            android:layout_alignLeft="@id/userPic"
            android:layout_marginTop="16dp"
            android:textSize="15sp"
            android:textColor="@color/black_light"
            android:text="RecyclerView实现瀑布流滚动"/>

        <ImageView
            android:id="@+id/Image"
            android:layout_below="@id/text"
            android:layout_marginTop="13dp"
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:src="@drawable/head"/>

        <TextView
            android:id="@+id/like"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/Image"
            android:layout_alignParentLeft="true"
            android:layout_marginTop="25dp"
            android:layout_marginLeft="20dp"
            android:drawableLeft="@drawable/ic_support_grey"
            android:drawablePadding="5dp"
            android:text="207"/>

        <TextView
            android:id="@+id/share"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignTop="@id/like"
            android:layout_centerInParent="true"
            android:layout_centerHorizontal="true"
            android:drawableLeft="@drawable/ic_share_grey"
            android:drawablePadding="5dp"
            android:text="582"/>

        <TextView
            android:id="@+id/comment"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentRight="true"
            android:layout_alignTop="@id/like"
            android:layout_marginRight="20dp"
            android:drawableLeft="@drawable/ic_comment"
            android:drawablePadding="5dp"
            android:text="401"/>

    </RelativeLayout>

</androidx.cardview.widget.CardView>
~~~

+ 使用RecyclerViwe布局实现外层滚动效果

~~~
<androidx.recyclerview.widget.RecyclerView
                android:id="@+id/recyclerView"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layout_behavior="@string/appbar_scrolling_view_behavior" />
~~~

+ 重写适配器

~~~
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
~~~

+ 后续功能接口

~~~
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
~~~

#### 最终效果

~~~
![演示1](./submit/docs/WeiboListFeature/WeiboListPic/1.png)
![演示2](./submit/docs/WeiboListFeature/WeiboListPic/2.png)
~~~
