package com.josrangel.myapplication.utils

import android.content.Context
import android.provider.Settings
import android.util.Log

/**
 * Source:
 * https://stackoverflow.com/questions/2744729/how-to-determine-the-current-ime-in-android
 * https://java.hotexamples.com/es/examples/android.provider/Settings.Secure/getString/java-settings.secure-getstring-method-examples.html
 */

class KeyboardUtils {

    companion object {

        fun isKeyboardSecurity(context: Context): Boolean {
            val keyboardApp: String = Settings.Secure.getString(
                context.getContentResolver(),
                Settings.Secure.DEFAULT_INPUT_METHOD
            )
            Log.i("keyboardApp", keyboardApp)
            val keyboardsEnable: String = Settings.Secure.getString(
                context.getContentResolver(),
                Settings.Secure.ENABLED_INPUT_METHODS
            )
            Log.i("keyboardsEnable", keyboardsEnable)
            return isKeyboardDefault(keyboardApp)
        }

        private fun isKeyboardDefault(keyboardsEnable: String): Boolean {
            val keyboardsDevice = keyboardsEnable.split(":").toTypedArray()
            for (keyboardEnable in keyboardsDevice) {
                if (keyboardEnable == "com.android.inputmethod.latin.Latin" ||
                    keyboardEnable.contains("com.android.inputmethod") ||
                    keyboardEnable.contains("com.google.android.inputmethod") ||
                    keyboardEnable.contains("com.touchtype.swiftkey") ||
                    keyboardEnable.contains("com.sec.android.inputmethod")
                ) {
                    return true
                }
            }
            return false
        }

    }

}