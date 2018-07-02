package com.hua.huahua.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetWorkUtil {

    companion object {
        fun isNetworkConnect(context: Context?): Boolean {
            val networkInfo: NetworkInfo? = getNetworkInfo(context,Context.CONNECTIVITY_SERVICE)
            return networkInfo !== null && networkInfo.isConnected
        }

        fun isWifiConnect(context: Context?): Boolean {
            val networkInfo: NetworkInfo? = getNetworkInfo(context,Context.WIFI_SERVICE)
            return networkInfo !== null && networkInfo.isConnected
        }

        fun getNetworkInfo(context: Context?,type:String): NetworkInfo? {
            if (context !== null) {
                val manager: ConnectivityManager? = context.applicationContext
                        .getSystemService(type) as ConnectivityManager?
                if (manager === null) return null
                return manager.activeNetworkInfo
            }
            return null
        }
    }
}