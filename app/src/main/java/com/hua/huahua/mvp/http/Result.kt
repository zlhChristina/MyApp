package com.hua.huahua.mvp.http

import com.google.gson.annotations.SerializedName

data class Result<T>(val status: Int = 0,
                     var message:String = "",var data: T? = null) {
}