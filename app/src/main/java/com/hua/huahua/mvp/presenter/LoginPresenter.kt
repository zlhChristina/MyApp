package com.hua.huahua.mvp.presenter

import com.hua.huahua.mvp.base.BasePresenter
import com.hua.huahua.mvp.contract.LoginContract
import com.hua.huahua.mvp.model.LoginModel

class LoginPresenter: BasePresenter<LoginModel, LoginContract>() {

    override fun createModel(): LoginModel? {
        return null
    }
}