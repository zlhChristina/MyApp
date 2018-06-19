package com.hua.huahua.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hua.huahua.mvp.base.BasePresenter;
import com.hua.huahua.mvp.base.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    private Unbinder unbinder;
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        unbinder = ButterKnife.bind(this);
        onActivityCreate();
        if (presenter == null) {
            presenter = createPresenter();
        }
        presenter.attach(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (presenter!=null){
            presenter.onDestroy();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    protected abstract void onActivityCreate();

    protected abstract int bindLayout();

    protected abstract P createPresenter();
}
