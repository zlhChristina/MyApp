package com.hua.huahua.activity

import android.view.KeyEvent
import com.hua.huahua.R
import com.hua.huahua.base.BaseActivity
import com.hua.huahua.mvp.base.BaseModel
import com.hua.huahua.mvp.base.BasePresenter
import com.hua.huahua.mvp.base.BaseView
import com.hua.huahua.util.ToastUtil

class MainActivity : BaseActivity<BasePresenter<BaseModel,BaseView>>() {

    private var exitTime: Long = 0

    override fun onActivityCreate() {
    }

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event!!.repeatCount == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.show(this, "再按一次即可退出APP")
                exitTime = System.currentTimeMillis()
            } else {
                finish()
                System.exit(0)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun createPresenter(): BasePresenter<BaseModel, BaseView>? {
        return null
    }
}
