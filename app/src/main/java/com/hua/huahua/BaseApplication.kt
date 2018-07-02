package com.hua.huahua

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(applicationContext, "0e00cf4aa6", true)
    }
}