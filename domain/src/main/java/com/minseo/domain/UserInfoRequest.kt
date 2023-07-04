package com.minseo.domain

data class UserInfoRequest(
    val uuid: String,
    val pushToken: String,
    val nickName: String? = null
)
