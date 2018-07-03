package com.hua.huahua.activity

import android.view.KeyEvent
import com.hua.base.view.BaseActivity
import com.hua.huahua.R

class MainActivity : BaseActivity() {

    private var exitTime: Long = 0

    override fun onActivityCreate() {
    }

    override fun bindContentLayout(): Int {
        return R.layout.activity_main
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event!!.repeatCount == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                toast("再按一次即可退出APP")
                exitTime = System.currentTimeMillis()
            } else {
                finish()
                System.exit(0)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun isHasTitleBar(): Boolean {
        return false
    }
}
