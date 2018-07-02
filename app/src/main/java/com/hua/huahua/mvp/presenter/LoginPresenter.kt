package com.hua.huahua.mvp.presenter

import com.hua.base.http.HttpManager
import com.hua.base.mvp.BasePresenter
import com.hua.huahua.mvp.api.LoginApi
import com.hua.huahua.mvp.bean.LoginResult
import com.hua.huahua.mvp.view.LoginView
import com.hua.huahua.mvp.http.ApiCallback
import com.hua.huahua.mvp.http.BaseObserver

interface ILoginPresenter {
    fun login(name: String, psw: String)
}

class LoginPresenter<V : LoginView>(v: V) : BasePresenter<LoginView>(v), ILoginPresenter {

    private var loginApi: LoginApi = HttpManager.getInstance().create(LoginApi::class.java)

    override fun login(name: String, psw: String) {
        observable(loginApi.login(name, psw))
                .subscribe(BaseObserver(object : ApiCallback<LoginResult> {
                    override fun onSuccess(t: LoginResult) {
                        view.loginSuccess(t)
                    }

                    override fun onFail(msg: String) {
                        view.loginFail(msg)
                    }
                }))

    }
}