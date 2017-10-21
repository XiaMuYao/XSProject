package com.xsproject.xsproject.UI.Fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xsproject.xsproject.R

/**
 * XiaMuYaodqx@gmail.com
 * @author XiaMuYao  2017/10/21
 * =========================
 * 说明：
 *
 *==========================
 */
class HomeFragment : Fragment() {
    var mRootView: ViewGroup? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater?.inflate(R.layout.fragment_home, container, false) as ViewGroup?
        return mRootView

    }

    companion object {
        fun getInstance(): HomeFragment {
            val bundle = Bundle()
            val instance = HomeFragment()
            instance.arguments = bundle
            return instance
        }
    }
}