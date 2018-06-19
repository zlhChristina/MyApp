package com.hua.huahua.mvp.api

import com.hua.huahua.mvp.bean.LoginResult
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.POST

interface LoginApi {

    @POST("login")
    fun login(@Field("phone") phone:String,@Field("password") password:String):Observable<LoginResult>

}