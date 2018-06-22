package com.hua.huahua.mvp.base;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BasePresenter<V extends BaseView> {

    protected WeakReference<V> iView;

    public BasePresenter(V v) {
        this.iView = new WeakReference<V>(v);
    }

    public <T> Observable observable(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public V getView() {
        if (iView != null) {
            return iView.get();
        }
        return null;
    }

    public void onDestroy() {
        if (iView != null) {
            iView.clear();
            iView = null;
            System.gc(); //让系统回收
        }
    }
}
