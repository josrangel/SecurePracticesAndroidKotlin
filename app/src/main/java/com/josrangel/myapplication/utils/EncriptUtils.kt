package com.josrangel.myapplication.utils

import android.util.Base64
import java.security.Key
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * Source: https://stackoverflow.com/questions/41223937/how-can-i-encrypte-my-password-android-studio
 */

class EncriptUtils {

    companion object {
        private val ALGORITHM = "AES"
        private val KEY = "t3st4E5k3Y2021aZ"

        fun encrypt(value: String): String? {
            val key: Key = generateKey()
            val cipher = Cipher.getInstance(ALGORITHM)
            cipher.init(Cipher.ENCRYPT_MODE, key)
            val encryptedByteValue =
                cipher.doFinal(value.toByteArray(Charsets.UTF_8))
            return Base64.encodeToString(encryptedByteValue, Base64.DEFAULT)
        }

        fun decrypt(value: String?): String? {
            val key: Key = generateKey()
            val cipher = Cipher.getInstance(ALGORITHM)
            cipher.init(Cipher.DECRYPT_MODE, key)
            val decryptedValue64: ByteArray = Base64.decode(value, Base64.DEFAULT)
            val decryptedByteValue = cipher.doFinal(decryptedValue64)
            return String(decryptedByteValue, Charsets.UTF_8)
        }

        private fun generateKey(): Key {
            return SecretKeySpec(KEY.toByteArray(), ALGORITHM)
        }
    }
}