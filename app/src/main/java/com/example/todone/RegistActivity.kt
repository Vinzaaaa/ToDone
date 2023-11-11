package com.example.todone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.method.PasswordTransformationMethod
import kotlinx.android.synthetic.main.activity_regist.back_2
import kotlinx.android.synthetic.main.activity_regist.txt_signin
import kotlinx.android.synthetic.main.activity_sign.back_1
import android.widget.EditText
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_regist.btn_2
import kotlinx.android.synthetic.main.activity_regist.edt_6

public class RegistActivity : AppCompatActivity() {

    private
    lateinit var editTextUsername: EditText

    private
    lateinit var editTextPassword: EditText

    private
    lateinit var editTextEmail: EditText

    private
    lateinit var editTextConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        editTextUsername = findViewById(R.id.edt_4)
        editTextPassword = findViewById(R.id.edt_5)
        editTextPassword.setTransformationMethod(PasswordTransformationMethod())
        editTextEmail = findViewById(R.id.edt_3)
        editTextConfirmPassword = findViewById(R.id.edt_6)
        editTextConfirmPassword.setTransformationMethod(PasswordTransformationMethod())
        btnBackListener()
        btnSignInListener()
        btnRegisterListener()
    }
    private fun btnRegisterListener() {
        btn_2.setOnClickListener {
            val email = editTextEmail.text.toString()
            if (emailExist(email)) {
                Toast.makeText(this, "Email Allready Used", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Cek apakah password dan confirm password sama
            if (editTextPassword.text.toString() != editTextConfirmPassword.text.toString()) {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cek apakah semua edittext terisi
            if (editTextUsername.text.toString().isEmpty() ||
                editTextPassword.text.toString().isEmpty() ||
                editTextEmail.text.toString().isEmpty() ||
                editTextConfirmPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Make sure all columns are filled in", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // simpan data register
            val sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", editTextUsername.text.toString())
            editor.putString("password", editTextPassword.text.toString())
            editor.putString("email", editTextEmail.text.toString())
            editor.putString("confirm_password", editTextConfirmPassword.text.toString())
            editor.apply()
            // tampilkan "Register Berhasil"
            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
            // Kembali Ke Halaman Login
            startActivity(Intent(this, SignActivity::class.java))
        }
    }

    private fun emailExist(email: String): Boolean {
        // cek apakah email sudah ada di shared preferences
        val sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
        val storedEmail = sharedPreferences.getString("email", "")
        return email == storedEmail
    }

    private fun btnBackListener() {
        back_2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun btnSignInListener() {
        txt_signin.setOnClickListener {
            startActivity(Intent(this, SignActivity::class.java))
        }
    }
}