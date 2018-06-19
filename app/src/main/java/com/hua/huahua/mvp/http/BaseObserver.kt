package com.hua.huahua.mvp.http

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open class BaseObserver<T>(val callback: ApiCallback<T>):Observer<T> {

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        callback.onSuccess(t)
    }

    override fun onError(e: Throwable) {
        callback.onFail(e.message!!)
    }
}