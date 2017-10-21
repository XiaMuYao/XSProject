package com.xsproject.xsproject.util

import android.app.Activity
import android.content.Intent
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import com.xsproject.xsproject.UI.Activity.MainActivity
import java.util.*


/**
 * shaomiaojava@gmail.com
 * @author shaomiao  2017/10/21
 * =========================
 * 说明：
 *
 *==========================
 */
class ActivitysManagement {

    private var activityStack:Stack<Activity>?=null
    companion object {
        var instance = ActivitysManagement()
    }


    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack!!.add(activity)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        var activity: Activity? = null
        if (activityStack == null || activityStack!!.count() < 0)
            return null
        try {
            activity = activityStack!!.lastElement()
        } catch (e: Exception) {
            // TODO: handle exception
            e.printStackTrace()
        }

        return activity
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        val activity = activityStack!!.lastElement()
        activity.finish()
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        if (activity != null) {
            activityStack!!.remove(activity)
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (activity in activityStack!!) {
            if (activity.javaClass == cls) {
                activity.finish()
            }
        }
    }

    fun getActivity(cls: Class<*>): Activity? {
        if (activityStack == null)
            return null
        for (activity in activityStack!!) {
            if (activity.javaClass == cls) {
                return activity
            }
        }
        return null
    }

    fun getActivity(className: String): Activity? {
        if (activityStack == null)
            return null
        for (activity in activityStack!!) {
            if (activity.javaClass.getSimpleName() == className) {
                return activity
            }
        }
        return null
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        var i = 0
        val size = activityStack!!.count()
        while (i < size) {
            if (null != activityStack!!.get(i)) {
                activityStack!!.get(i).finish()
            }
            i++
        }
        activityStack!!.clear()
    }

    fun getActivityCount(): Int {
        return activityStack!!.count()
    }

    /**
     * 获取屏幕实时尺寸
     *
     * @param activity
     * @return DisplayMetrics.widthPixels, DisplayMetrics.heightPixels
     * DisplayMetrics.xdpi, DisplayMetrics.ydpi
     */
    fun displayMetrics(activity: Activity): DisplayMetrics {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay
                .getMetrics(displayMetrics)
        return displayMetrics
    }

    /**
     * @param activity
     * @return sample:getWindowView(activity).getHeight()
     */
    fun getWindowView(activity: Activity): View? {
        var view: View? = null
        try {
            view = activity.window.findViewById(Window.ID_ANDROID_CONTENT)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return view
    }

    /**
     * 获取状态栏的高度, 需要在页面渲染完成之后调用
     *
     * @param activity
     * @return
     */
    fun getStatusBarHeight(activity: Activity): Int {
        val rect = Rect()
        activity.window.decorView.getWindowVisibleDisplayFrame(rect)
        return rect.top
    }

    fun finishOtherActivity() {
        if (activityStack == null)
            return
        for (i in 0 until activityStack!!.count()) {
            if (i == activityStack!!.count() - 1) {
                activityStack!!.get(i).startActivity(Intent(activityStack!!.get(i), MainActivity::class.java))
                activityStack!!.get(i).finish()
            } else {
                activityStack!!.get(i).finish()
            }
        }
    }

}