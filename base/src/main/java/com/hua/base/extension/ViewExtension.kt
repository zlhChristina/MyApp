package com.hua.base.extension

import android.content.Context
import android.view.View
import android.view.View.*
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * View 扩展函数
 * Author: zlh
 * Data：2018/7/6-16:17
 * Description:
 */

fun View.isGone(): Boolean {
    return visibility == GONE
}

fun View.gone() {
    visibility = GONE
}

fun View.isVisible(): Boolean {
    return visibility == VISIBLE
}

fun View.show() {
    visibility = VISIBLE
}

fun View.isInvisible(): Boolean {
    return visibility == INVISIBLE
}

fun View.hide() {
    visibility = INVISIBLE
}

fun ImageView.loadImage(context: Context, path: String) {
    Glide.with(context).load(path).apply(getOptions())
            .into(this)
}

/**
 * 加载圆形图片
 */
fun ImageView.loadCircleImage(context: Context, path: String) {
    var options = getOptions()
    options.circleCrop()
    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆角图片
 */
fun ImageView.loadRoundCornerImage(context: Context, path: String, roundingRadius: Int = 32) {
    Glide.with(context).load(path).apply(RequestOptions.bitmapTransform(RoundedCorners(roundingRadius))).apply(getOptions()).into(this)
}

private fun getOptions(): RequestOptions {
    val options = RequestOptions()
    options.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
    return options
}


fun View.setWidth(width: Int) {
    val params = layoutParams as LinearLayout.LayoutParams
    params.width = width
    layoutParams = params
}

fun View.setHeight(height: Int) {
    val params = layoutParams as LinearLayout.LayoutParams
    params.height = height
    layoutParams = params
}

/**
 * 直接获取控件的宽、高
 * @return IntArray
 */
fun View.getWidgetWH(): IntArray {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeGlobalOnLayoutListener(this)
        }
    })
    return intArrayOf(width, height)
}
