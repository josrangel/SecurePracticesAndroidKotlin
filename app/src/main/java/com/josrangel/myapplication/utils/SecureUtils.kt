package com.josrangel.myapplication.utils

import android.view.Window
import android.view.WindowManager

import androidx.appcompat.app.AppCompatActivity

/**
 * Source: https://stackoverflow.com/questions/38404237/how-to-hide-views-in-android-when-android-app-is-backgrounded-not-to-stop-andro
 */

class SecureUtils {

    companion object {

        fun makeSecureActivity(activity: AppCompatActivity) {
            activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
            activity.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        }

    }

}