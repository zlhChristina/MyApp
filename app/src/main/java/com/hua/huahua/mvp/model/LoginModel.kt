package com.hua.huahua.mvp.model

import com.hua.huahua.mvp.api.LoginApi
import com.hua.huahua.mvp.base.BaseModel
import com.hua.huahua.mvp.bean.LoginResult
import com.hua.huahua.mvp.contract.LoginContract
import com.hua.huahua.mvp.http.ApiCallback
import com.hua.huahua.mvp.http.BaseObserver
import com.hua.huahua.mvp.http.HttpManager

class LoginModel : BaseModel(), LoginContract.loginModel {

    private var loginApi: LoginApi=HttpManager.getInstance().create(LoginApi::class.java)

    override fun login(name: String, psw: String) {
        observable(loginApi.login("","")).subscribe(BaseObserver(object :ApiCallback<LoginResult>{
            override fun onSuccess(t: LoginResult) {

            }

            override fun onFail(msg: String) {
            }
        }))
    }


}