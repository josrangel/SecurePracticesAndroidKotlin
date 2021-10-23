package com.josrangel.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.josrangel.myapplication.utils.EncriptUtils

class MainActivity : AppCompatActivity() {

    lateinit var etEncrypt: EditText
    lateinit var etNormal: EditText
    lateinit var btnEncrypt: Button
    lateinit var btnDecrypt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}