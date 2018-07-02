package com.hua.base.update

import android.content.Context

/**
 * Author: zlh
 * Data：2018/6/30-11:22
 * Description:
 */
class UpdateUtil {

    companion object {
        fun updateApp(context: Context, versionInfo: VersionInfo) {
            if (versionInfo.versionCode.toInt() > getAppLocalVersion(context)) {
                DownloadUtil.downloadApk(context,versionInfo.url,"宠物之家更新","cat.apk")
            }
        }

        fun getAppLocalVersion(context: Context): Int {
            val manager = context.packageManager
            val info = manager.getPackageInfo(context.packageName, 0)
            return info.versionCode
        }
    }
}