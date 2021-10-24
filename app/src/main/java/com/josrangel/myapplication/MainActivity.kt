package com.josrangel.myapplication

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.josrangel.myapplication.utils.EncriptUtils
import com.josrangel.myapplication.utils.RootingUtils

/**
 * Source:
 * https://stackoverflow.com/questions/38404237/how-to-hide-views-in-android-when-android-app-is-backgrounded-not-to-stop-andro
 *
 */

class MainActivity : AppCompatActivity() {

    lateinit var etEncrypt: EditText
    lateinit var etNormal: EditText
    lateinit var btnEncrypt: Button
    lateinit var btnDecrypt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makesecurityActivity()
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
    }

    private fun encriptText() {
        var textEncript = EncriptUtils.encrypt(etNormal.text.toString())
        etEncrypt.setText(textEncript)
    }

    private fun decriptText() {
        var textDecript = EncriptUtils.decrypt(etEncrypt.text.toString())
        etNormal.setText(textDecript)
    }

    private fun makesecurityActivity() {
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        );
    }

    private fun verifyRooted() {
        if (RootingUtils.isDeviceRooted()) {
            Toast.makeText(this, getString(R.string.text_root_detected), Toast.LENGTH_LONG).show();
            finish();
        }
    }
}