package com.hua.base.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Author: zlh
 * Data：2018/7/2-16:41
 * Description:
 */
class SPUtil {

    companion object {
        fun getSP(context: Context): SharedPreferences? {
            val sp = context.getSharedPreferences("animal_sp_file.xml", Context.MODE_PRIVATE)
            return sp
        }

        fun saveData(context: Context, key: String, value: String) {
            val editor = getSP(context)?.edit()
            editor?.putString(key, value)
            editor?.commit()
        }

        fun getData(context: Context, key: String): String? {
            return getSP(context)?.getString(key, "")
        }

        fun saveData(context: Context, key: String, value: Class<Any>) {

        }
    }
}