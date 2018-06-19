package com.hua.huahua.mvp.api

import com.hua.huahua.mvp.bean.LoginResult
import com.hua.huahua.mvp.http.Result
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.*

interface LoginApi {

    @POST("login")
    fun login(@Field("phone") phone:String,@Field("password") password:String):Observable<Result<LoginResult>>

}