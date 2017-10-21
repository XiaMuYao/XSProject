package com.xsproject.xsproject.UI.Activity

import android.app.Activity
import android.app.Fragment
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.xsproject.xsproject.R
import com.xsproject.xsproject.UI.Fragment.FindFragment
import com.xsproject.xsproject.UI.Fragment.HomeFragment
import com.xsproject.xsproject.UI.Fragment.MyFragment
import com.xsproject.xsproject.UI.Fragment.StartFragment
import kotlinx.android.synthetic.main.activity_main.*


/**
 * XiaMuYaodqx@gmail.com
 * @author XiaMuYao  2017/10/21
 * =========================
 * 说明：
 *
 *==========================
 */
class MainActivity : Activity() {

    /**
     * 当前选中的页
     */
    private var currentModel: Int? = null
    var mHomeFragment: HomeFragment? = null
    var mStartFragment: StartFragment? = null
    var mFindFragment: FindFragment? = null
    var mMyFragment: MyFragment? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyListener()
    }

    /**
     * 设置监听事件
     */
    @RequiresApi(Build.VERSION_CODES.N)
    private fun MyListener() {
        main_home.setOnClickListener {
            setBottomMenu(0)
            selectFragmenf(0)
        }
        main_star.setOnClickListener {
            setBottomMenu(1)
            selectFragmenf(1)
        }
        main_find.setOnClickListener {
            setBottomMenu(2)
            selectFragmenf(2)
        }
        main_my.setOnClickListener {
            setBottomMenu(3)
            selectFragmenf(3)
        }
    }

    /**
     * 底部状态改变
     */
    private fun setBottomMenu(index: Int) {
        when (index) {
            0 -> {
                main_home_iv.setImageResource(R.mipmap.ic_tab_strip_icon_feed_selected)
                main_star_iv.setImageResource(R.mipmap.ic_tab_strip_icon_follow)
                main_find_ic.setImageResource(R.mipmap.ic_tab_strip_icon_category)
                main_my_ic.setImageResource(R.mipmap.ic_tab_strip_icon_profile)

                main_home_tv.setTextColor(Color.BLUE)
                main_star_tv.setTextColor(Color.RED)
                main_find_tv.setTextColor(Color.RED)
                main_my_tv.setTextColor(Color.RED)

            }
            1 -> {
                main_home_iv.setImageResource(R.mipmap.ic_tab_strip_icon_feed)
                main_star_iv.setImageResource(R.mipmap.ic_tab_strip_icon_follow_selected)
                main_find_ic.setImageResource(R.mipmap.ic_tab_strip_icon_category)
                main_my_ic.setImageResource(R.mipmap.ic_tab_strip_icon_profile)

                main_home_tv.setTextColor(Color.RED)
                main_star_tv.setTextColor(Color.BLUE)
                main_find_tv.setTextColor(Color.RED)
                main_my_tv.setTextColor(Color.RED)


            }
            2 -> {
                main_home_iv.setImageResource(R.mipmap.ic_tab_strip_icon_feed)
                main_star_iv.setImageResource(R.mipmap.ic_tab_strip_icon_follow)
                main_find_ic.setImageResource(R.mipmap.ic_tab_strip_icon_category_selected)
                main_my_ic.setImageResource(R.mipmap.ic_tab_strip_icon_profile)

                main_home_tv.setTextColor(Color.RED)
                main_star_tv.setTextColor(Color.RED)
                main_find_tv.setTextColor(Color.BLUE)
                main_my_tv.setTextColor(Color.RED)

            }
            3 -> {
                main_home_iv.setImageResource(R.mipmap.ic_tab_strip_icon_feed)
                main_star_iv.setImageResource(R.mipmap.ic_tab_strip_icon_follow)
                main_find_ic.setImageResource(R.mipmap.ic_tab_strip_icon_profile)
                main_my_ic.setImageResource(R.mipmap.ic_tab_strip_icon_profile_selected)

                main_home_tv.setTextColor(Color.RED)
                main_star_tv.setTextColor(Color.RED)
                main_find_tv.setTextColor(Color.BLUE)
                main_my_tv.setTextColor(Color.RED)
            }


        }

    }

    /**
     * 更改选中的Fragment
     */
    @RequiresApi(Build.VERSION_CODES.N)
    private fun selectFragmenf(index: Int) {
        if (mHomeFragment != null) {
            fragmentManager.beginTransaction()
                    .hide(mHomeFragment)
                    .commitNowAllowingStateLoss()
        }
        when (index) {
            0 -> {
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance()
                }
                showFragment(mHomeFragment, index)
            }
            1 -> {
                if (mStartFragment == null) {
                    mStartFragment = StartFragment.getInstance()
                }
                showFragment(mStartFragment, index)
            }
            2 -> {
                if (mFindFragment == null) {
                    mFindFragment = FindFragment.getInstance()
                }
                showFragment(mFindFragment, index)
            }
            3 -> {
                if (mMyFragment == null) {
                    mMyFragment = MyFragment.getInstance()
                }
                showFragment(mMyFragment, index)
            }
        }
    }

    /**
     * 选择显示的Fragment
     */
    private fun showFragment(fragment: Fragment?, model: Int) {
        if (!(fragment?.isAdded as Boolean)) {
            fragmentManager.beginTransaction()
                    .add(R.id.main_fragmelayout, fragment)
                    .commitAllowingStateLoss()
        }
        if (fragment?.isDetached as Boolean) {
            fragmentManager.beginTransaction().attach(fragment).commitAllowingStateLoss()
        } else if (fragment?.isHidden!!) {
            fragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss()
        }
        currentModel = model
        mHomeFragment = fragment as HomeFragment?
    }

}