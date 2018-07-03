package com.hua.huahua.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.KeyEvent
import android.widget.RadioGroup
import com.hua.base.view.BaseActivity
import com.hua.huahua.R
import com.hua.huahua.fragment.IndexFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),RadioGroup.OnCheckedChangeListener {

    private var exitTime: Long = 0
    private var adapter: PagerAdapter? = null

    override fun onActivityCreate() {
        adapter = if (adapter == null) PagerAdapter(supportFragmentManager) else adapter
        vp_main.adapter = adapter
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

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {

    }

    override fun isHasTitleBar(): Boolean {
        return false
    }

    class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        override fun getItem(p0: Int): Fragment {
            return IndexFragment()
        }

        override fun getCount(): Int {
            return 4
        }

    }
}
