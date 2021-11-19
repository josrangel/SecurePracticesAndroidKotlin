package com.josrangel.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.josrangel.myapplication.utils.EncriptUtils
import com.josrangel.myapplication.utils.KeyboardUtils
import com.josrangel.myapplication.utils.RootingUtils
import com.josrangel.myapplication.utils.SecureUtils

/**
 * Source:
 * for prevent tapjacking attacks -> filterTouchesWhenObscured in view and manifest: https://medium.com/devknoxio/what-is-tapjacking-in-android-and-how-to-prevent-it-50140e57bf44
 * for prevent task hijacking attacks -> taskAffinity in blank in manifest: https://blog.takemyhand.xyz/2021/02/android-task-hijacking-with.html#:~:text=What%20is%20task%20hijacking%20in%20Android%3F%20Task%20hijacking,greeted%20by%20the%20activity%20of%20the%20malicious%20app.
 */

class MainActivity : AppCompatActivity() {

    lateinit var etEncrypt: EditText
    lateinit var etNormal: EditText
    lateinit var btnEncrypt: Button
    lateinit var btnDecrypt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeSecureActivity()
        setContentView(R.layout.activity_main)
        verifyRooted()
        initIU()
    }

    private fun initIU() {
        etEncrypt = findViewById(R.id.et_encript)
        etNormal = findViewById(R.id.et_normal)
        btnEncrypt = findViewById(R.id.b_encrypt)
        btnDecrypt = findViewById(R.id.b_decrypt)

        btnEncrypt.setOnClickListener {
            encriptText()
        }

        btnDecrypt.setOnClickListener {
            decriptText()
        }

        etEncrypt.setOnFocusChangeListener(View.OnFocusChangeListener { _, _ ->
            verifyKeyboard()
        })

        etNormal.setOnFocusChangeListener(View.OnFocusChangeListener { _, _ ->
            verifyKeyboard()
        })
    }

    private fun encriptText() {
        var textEncript = EncriptUtils.encrypt(etNormal.text.toString())
        etEncrypt.setText(textEncript)
    }

    private fun decriptText() {
        var textDecript = EncriptUtils.decrypt(etEncrypt.text.toString())
        etNormal.setText(textDecript)
    }

    private fun verifyKeyboard() {
        if (!KeyboardUtils.isKeyboardSecurity(this)) {
            Toast.makeText(this, getString(R.string.text_warning_ime_keyboard), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun makeSecureActivity() {
        SecureUtils.makeSecureActivity(this)
    }

    private fun verifyRooted() {
        if (RootingUtils.isDeviceRooted(this)) {
            Toast.makeText(this, getString(R.string.text_root_detected), Toast.LENGTH_LONG).show()
            finish()
        }
    }
}