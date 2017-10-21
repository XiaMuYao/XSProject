package com.xsproject.xsproject.UI.base

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.view.View
import com.xsproject.xsproject.util.ActivitysManagement
import kotlinx.android.synthetic.main.layout_title.*

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

    fun setTitle(text:String) {
        if (null!=tTitle) {
            tTitle.visibility=View.VISIBLE
            tTitle.setText(text)
        }
    }

    fun getTitleString():String {
        return tTitle.text.toString()
    }

    fun setLeftImageView(resId:Int,onClickListener: View.OnClickListener) {
        if (null != img_left){
            img_left.visibility = View.VISIBLE
            img_left.setImageResource(resId)
        }
        if (null != ll_top_left)
            ll_top_left.setOnClickListener(onClickListener)
    }

}