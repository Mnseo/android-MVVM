package com.minseo.domain.repository

import com.minseo.domain.model.UserInfoModel
import com.minseo.domain.UserInfoRequest
import kotlinx.coroutines.flow.Flow

interface UserInfoRepository {

    //post
    fun saveUserId(id: String)
    fun postUserInfo(request: UserInfoRequest) : Flow<Unit>
    fun postUserNickname(request: UserInfoRequest): Flow<Unit>

    //getter
    fun getUserId(): Flow<String>
    fun getUserDeviceToken(): Flow<String?>
    fun getUserNickname(): Flow<String?>
    fun getUserInfo(id:String): Flow<UserInfoModel>

    //check
    fun checkUserNickname(nickname: String) : Flow<Unit>


}