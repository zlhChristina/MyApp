package com.hua.huahua.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import java.io.Serializable

class NavigationUtil {

    companion object {
        fun <T : Activity> intent(context: Context, clazz: Class<T>) {
            val intent = Intent(context, clazz)
            context.startActivity(intent)
        }

        fun <T : Activity> intent(context: Context, clazz: Class<T>, key: String, data: Serializable) {
            val intent = Intent(context, clazz)
            intent.putExtra(key, data)
            context.startActivity(intent)
        }

        fun <T : Activity> intentForResult(activity: Activity, clazz: Class<T>, requestCode: Int) {
            val intent = Intent(activity, clazz)
            activity.startActivityForResult(intent, requestCode)
        }

        fun <T : Activity> intentForResult(activity: Activity, clazz: Class<T>, requestCode: Int, key: String, data: Serializable) {
            val intent = Intent(activity, clazz)
            intent.putExtra(key, data)
            activity.startActivityForResult(intent, requestCode)
        }

    }
}