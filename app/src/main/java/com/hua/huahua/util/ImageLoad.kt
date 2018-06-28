package com.hua.huahua.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.io.File

class ImageLoad {
    companion object {
        fun load(context: Context, resId: Int, imageView: ImageView) {
            val options = RequestOptions()
            options.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            Glide.with(context).load(resId).apply(options)
                    .into(imageView)
        }

        fun load(context: Context, url: String, imageView: ImageView) {
            Glide.with(context).load(url)
                    .into(imageView)
        }

        fun load(context: Context, file: File, imageView: ImageView) {
            Glide.with(context).load(file)
                    .into(imageView)
        }
    }
}