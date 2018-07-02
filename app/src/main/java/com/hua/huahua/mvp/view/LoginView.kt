package com.hua.huahua.mvp.view

import com.hua.base.mvp.BaseView
import com.hua.huahua.mvp.bean.LoginResult

interface LoginView: BaseView {

    fun loginSuccess(loginResult: LoginResult)
    fun loginFail(msg:String)

}