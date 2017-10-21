package com.xsproject.xsproject.Util

import android.app.Activity
import android.widget.Toast

/**
 * XiaMuYaodqx@gmail.com
 * @author XiaMuYao  2017/10/21
 * =========================
 * 说明：
 *
 *==========================
 */


/**
 * 显示Toast的工具
 */
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(application, message, duration).show()
}