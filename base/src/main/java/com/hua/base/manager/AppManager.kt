package com.hua.base.manager

import android.app.Activity
import java.util.*


/**
 * Author: zlh
 * Data：2018/6/30-17:52
 * Description:
 */
class AppManager {

    companion object {
        var activityStack: Stack<Activity>? = null
        val appManager: AppManager? = null

        fun getInstance(): AppManager {
            return if (appManager == null) AppManager() else appManager
        }

        fun getActivity(cls: Class<*>): Activity? {
            if (activityStack != null)
                for (activity in activityStack!!) {
                    if (activity.javaClass == cls) {
                        return activity
                    }
                }
            return null
        }
    }

    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack<Activity>()
        }
        activityStack?.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activityStack?.remove(activity)
    }

    fun finishAllActivity() {
        if (activityStack != null)
            for (activity in activityStack!!) {
                activity.finish()
            }
        activityStack?.clear()
    }
}