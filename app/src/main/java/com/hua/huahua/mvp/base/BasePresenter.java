package com.hua.huahua.mvp.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {

    private M model;
    private WeakReference<V> view;

    public void attach(V v) {
        this.view = new WeakReference<V>(v);
        if (model == null) {
            model = createModel();
        }
    }

    public void onDestroy() {
        if (view != null) {
            view.clear();
            view = null;
        }
    }

    protected abstract M createModel();
}
