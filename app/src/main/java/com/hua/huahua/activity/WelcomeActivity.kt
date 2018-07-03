package com.hua.huahua.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hua.base.util.StatusBarUtil
import com.hua.huahua.R
import com.hua.huahua.util.ImageLoad
import com.hua.huahua.util.NavigationUtil
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 * Author: zlh
 * Data：2018/7/3-11:43
 * Description:
 */
class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBarTransparent(this)
        setContentView(R.layout.activity_welcome)
        ImageLoad.load(this, R.drawable.ic_welcome, iv_welcome)
        iv_welcome.setOnClickListener {
            NavigationUtil.intent(this,MainActivity::class.java)
            finish()
        }
    }
}