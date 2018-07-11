package com.hua.base.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.hua.base.R
import com.hua.base.extension.gone
import com.hua.base.extension.show

/**
 * Author: zlh
 * Data：2018/7/5-16:40
 * Description:
 */
abstract class BasePagedAdapter<T>(val list: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onAgainListener: OnAgainClickListener? = null

    companion object {
        const val TYPE_ITEM = 1001
        const val TYPE_FOOTER = 1002
        const val LOADING_MORE = 1003
        const val NO_MORE = 1004
        const val LOADING_ERROR = 1005
        var footerState = 1004
    }

    open fun changeState(state: Int) {
        footerState = state
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_ITEM -> {
                return getHolder()
            }
            TYPE_FOOTER -> {
                return FootViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_foot_view, parent, false))
            }
        }
        return getHolder()
    }

    override fun getItemCount(): Int {
        return if (list.isEmpty()) 0 else list.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = getItemViewType(position)
        when (type) {
            TYPE_ITEM -> {
                bindViewHolder()
            }
            TYPE_FOOTER -> {
                val h: FootViewHolder = holder as FootViewHolder
                when (footerState) {
                    LOADING_MORE -> {
                        h.llLoading.show()
                        h.llError.gone()
                        h.llNoMore.gone()
                    }
                    NO_MORE -> {
                        h.llLoading.gone()
                        h.llError.gone()
                        h.llNoMore.show()
                    }
                    LOADING_ERROR -> {
                        h.llLoading.gone()
                        h.llError.show()
                        h.llNoMore.gone()
                        h.tvAgain.setOnClickListener {
                            if (onAgainListener != null) {
                                onAgainListener!!.onAgain()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position + 1 == itemCount) {
            return TYPE_FOOTER
        }
        return TYPE_ITEM
    }

    class FootViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val llLoading = itemView.findViewById<LinearLayout>(R.id.ll_loading)
        val llNoMore = itemView.findViewById<LinearLayout>(R.id.ll_no_more)
        val llError = itemView.findViewById<LinearLayout>(R.id.ll_error)
        val tvAgain = itemView.findViewById<TextView>(R.id.tv_again)
    }

    interface OnAgainClickListener {
        fun onAgain()
    }

    protected abstract fun getHolder(): RecyclerView.ViewHolder

    protected abstract fun bindViewHolder()
}