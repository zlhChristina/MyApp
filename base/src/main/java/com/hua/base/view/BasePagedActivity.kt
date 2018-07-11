package com.hua.base.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


/**
 * Author: zlh
 * Data：2018/7/5-16:27
 * Description:
 */
abstract class BasePagedActivity<T> : BaseActivity() {

    protected var mRcy: RecyclerView? = null
    var page = 0
    var isLoading = false
    var totalPage = 3
    var lastVisibleItem: Int = 0

    override fun onActivityCreate() {
        mRcy = getRcy()
        if (mRcy != null) {
            mRcy!!.layoutManager = layoutManager()
            mRcy!!.adapter = getAdapter()
            mRcy!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                            lastVisibleItem + 1 == getAdapter().itemCount && !isLoading) {
                        if (page < totalPage) {
                            isLoading = true
                            getAdapter().changeState(BasePagedAdapter.LOADING_MORE)
                        }else{
                            getAdapter().changeState(BasePagedAdapter.NO_MORE)
                        }
                    }
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    //拿到最后一个出现的item的位置
                    lastVisibleItem = (layoutManager() as LinearLayoutManager).findLastVisibleItemPosition()
                }
            })
            getAdapter().onAgainListener = object : BasePagedAdapter.OnAgainClickListener {
                override fun onAgain() {

                }
            }
        }
    }

    protected fun layoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(this)
    }

    protected abstract fun getRcy(): RecyclerView

    protected abstract fun getAdapter(): BasePagedAdapter<T>
}