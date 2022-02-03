package com.manish.carshopee.component

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

//Activity extension
fun FragmentActivity.replace(
    fragment: Fragment, resContainer: Int,
    isBackStack: Boolean,
    backStackName: String?
) {
    with(this.supportFragmentManager.beginTransaction()) {
        if (isBackStack)
            this.addToBackStack(backStackName)

        this.replace(resContainer, fragment, backStackName)
        this.commit()
    }
}
//View Extension
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
