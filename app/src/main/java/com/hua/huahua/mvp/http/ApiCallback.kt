package com.hua.huahua.mvp.http

interface ApiCallback<T> {

    fun onSuccess(t: T)
    fun onFail(msg: String)
}