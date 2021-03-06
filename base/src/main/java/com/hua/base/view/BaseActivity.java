package com.hua.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hua.base.R;
import com.hua.base.manager.AppManager;
import com.hua.base.mvp.BaseView;
import com.hua.base.util.StatusBarUtil;
import com.hua.huahua.util.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder unbinder;
    protected TextView tvTitle;
    protected ImageView ivBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        LinearLayout baseContainer = findViewById(R.id.ll_base);
        if (isHasTitleBar() && bindTitleLayoutId() != 0) {
            LayoutInflater.from(this).inflate(bindTitleLayoutId(), baseContainer);
            tvTitle = findViewById(R.id.tv_title);
            ivBack = findViewById(R.id.iv_back);
            ivBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackClick();
                }
            });
        }
        if (bindContentLayout() != 0) {
            LayoutInflater.from(this).inflate(bindContentLayout(), baseContainer);
        }
        StatusBarUtil.Companion.setStatusBar(this);
        unbinder = ButterKnife.bind(this);
        onActivityCreate();
        AppManager.Companion.getInstance().addActivity(this);
    }

    @Override
    public void onBackPressed() {
        onBackClick();
    }

    protected boolean isHasTitleBar() {
        return true;
    }

    protected int bindTitleLayoutId() {
        return R.layout.title_layout;
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    protected void onBackClick() {
        finish();
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
        AppManager.Companion.getInstance().removeActivity(this);
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

    protected abstract int bindContentLayout();

}
