package com.josrangel.myapplication.utils

import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * Source:
 * https://stackoverflow.com/questions/38404237/how-to-hide-views-in-android-when-android-app-is-backgrounded-not-to-stop-andro
 * https://medium.com/nomtek/screenshot-preventing-on-mobile-apps-9e62f51643e9
 */

class SecureUtils {

    companion object {

        fun makeSecureActivity(activity: AppCompatActivity) {
            activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }

    }

}