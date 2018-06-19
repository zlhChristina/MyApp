package com.hua.huahua.activity

import android.view.KeyEvent
import com.hua.huahua.R
import com.hua.huahua.base.BaseActivity

class MainActivity : BaseActivity() {

    private var exitTime: Long = 0

    override fun onActivityCreate() {
    }

    override fun bindLayout(): Int {
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
}
