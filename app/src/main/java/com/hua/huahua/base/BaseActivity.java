package com.hua.huahua.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.hua.huahua.R;
import com.hua.huahua.mvp.base.BaseView;
import com.hua.huahua.util.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        LinearLayout baseContainer = findViewById(R.id.ll_base);
        LayoutInflater.from(this).inflate(bindLayout(),baseContainer);
        unbinder = ButterKnife.bind(this);
        onActivityCreate();
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
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void dismissLoading() {
    }

    public void toast(String msg) {
        ToastUtil.Companion.show(this, msg);
    }

    protected abstract void onActivityCreate();

    protected abstract int bindLayout();

}
