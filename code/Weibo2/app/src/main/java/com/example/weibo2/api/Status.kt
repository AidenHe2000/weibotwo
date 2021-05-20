package com.example.weibo2.api

//微博
class Status(
    val created_at: String,
    val id: Long,
    val mid: Long,
    val idstr: String,
    val text: String,
    val source: String,
    val favorited: Boolean,
    val truncated: Boolean,
    val in_reply_to_status_id: String,
    val in_reply_to_user_id: String,
    val in_reply_to_screen_name: String,
    val thumbnail_pic: String,
    val bmiddle_pic: String,
    val original_pic: String,
    val geo: Geo,
    val user: User,
    val retweeted_status: Status,
    val reposts_count: Int,
    val comments_count: Int,
    val attitudes_count: Int,
    val mlevel: Int,
    val visible: Int,
    val pic_ids: String,
    val ad: List<String>
)