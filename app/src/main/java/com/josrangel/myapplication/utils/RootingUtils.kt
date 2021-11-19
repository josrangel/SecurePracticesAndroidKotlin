package com.josrangel.myapplication.utils

import android.content.Context
import android.os.Build
import com.scottyab.rootbeer.RootBeer
import java.io.File


/**
 * Source: https://stackoverflow.com/questions/1101380/determine-if-running-on-a-rooted-device
 */

class RootingUtils {

    companion object {
        fun isDeviceRooted(context: Context): Boolean {
            val rootBeer = RootBeer(context)
            return rootBeer.isRooted || checkRootMethod1() || checkRootMethod2()
        }

        //check for emulators
        private fun checkRootMethod1(): Boolean {
            val buildTags = Build.TAGS
            return buildTags != null && buildTags.contains("test-keys")
        }

        //check for directories for super user
        private fun checkRootMethod2(): Boolean {
            val paths = arrayOf(
                "/system/app/Superuser.apk",
                "/sbin/su",
                "/system/bin/su",
                "/system/xbin/su",
                "/data/local/xbin/su",
                "/data/local/bin/su",
                "/system/sd/xbin/su",
                "/system/bin/failsafe/su",
                "/data/local/su",
                "/su/bin/su"
            )

            for (path in paths) {
                if (File(path).exists()) return true
            }
            return false
        }
    }

}