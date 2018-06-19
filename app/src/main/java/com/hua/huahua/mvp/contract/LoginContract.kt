package com.hua.huahua.mvp.contract

import com.hua.huahua.mvp.base.BaseView

interface LoginContract:BaseView {

    interface loginModel {
        fun login(name: String, psw: String)
    }
}