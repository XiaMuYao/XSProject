package com.xsproject.xsproject.UI.base

import android.app.Activity
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
abstract class BaseActivity :FragmentActivity() {

    var mActivity: Activity? = null


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ActivitysManagement.instance.addActivity(this)
        setContentView(getLayout())
        initObject(savedInstanceState!!);
        //initTitle();
        mActivity = this
        //TODO loading


    }



    abstract fun initObject(savedInstanceState: Bundle)
    abstract fun getLayout(): Int

}