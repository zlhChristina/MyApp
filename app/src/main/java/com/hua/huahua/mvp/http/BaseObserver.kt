package com.hua.huahua.mvp.http

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open class BaseObserver<T>(val callback: ApiCallback<T>) : Observer<T> {

    protected var disposable: Disposable? = null  //订阅者，当请求完成或出错之后解除订阅

    override fun onComplete() {
        if (disposable != null && !disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(t: T) {
        callback.onSuccess(t)
    }

    override fun onError(e: Throwable) {
        callback.onFail(e.message!!)
        if (disposable != null && !disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }
}