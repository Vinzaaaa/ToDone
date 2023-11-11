package com.example.todone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import kotlinx.android.synthetic.main.activity_sign.back_1
import kotlinx.android.synthetic.main.activity_sign.txt_signup
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign.btn_1

class SignActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        editTextUsername = findViewById(R.id.edt_1)
        editTextPassword = findViewById(R.id.edt_2)
        editTextPassword.setTransformationMethod(PasswordTransformationMethod())
        btnBackListener()
        btnSubmitListener()
        btnSignUpListener()

    }

    private fun btnBackListener() {
        back_1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun btnSubmitListener() {
        btn_1.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            val sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
            val storedUsername = sharedPreferences.getString("username", "")
            val storedPassword = sharedPreferences.getString("password", "")
            if (username == storedUsername && password == storedPassword) {
                // Login berhasil
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Kembali ke halaman utama
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                // Login gagal
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun btnSignUpListener() {
        txt_signup.setOnClickListener {
            startActivity(Intent(this, RegistActivity::class.java))
        }
    }
}