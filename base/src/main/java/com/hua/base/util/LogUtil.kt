package com.hua.huahua.util

import android.util.Log

class LogUtil {

    companion object {
        fun getTag(): String? {
            val sts = Thread.currentThread().stackTrace
            if (sts != null) {
                for (st in sts) {
                    if (st.isNativeMethod) continue
                    if (st.className === Thread::javaClass.name) continue
                    if (st.className === LogUtil::javaClass.name) continue
                    return st.className + "." + st.methodName + "(" + st.fileName + ":" + st.lineNumber + ")"
                }
            }
            return null
        }

        fun v(msg: String) {
            Log.v(getTag(), msg)
        }

        fun i(msg: String) {
            Log.i(getTag(), msg)
        }

        fun d(msg: String) {
            Log.d(getTag(), msg)
        }

        fun w(msg: String) {
            Log.w(getTag(), msg)
        }

        fun e(msg: String) {
            Log.e(getTag(), msg)
        }
    }
}