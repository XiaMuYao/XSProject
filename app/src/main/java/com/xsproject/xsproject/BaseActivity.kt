package com.xsproject.xsproject

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import com.xsproject.xsproject.util.ActivitysManagement

/**
 * shaomiaojava@gmail.com
 * @author shaomiao  2017/10/21
 * =========================
 * 说明：
 *
 *==========================
 */
class BaseActivity :FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ActivitysManagement.AM
    }

}