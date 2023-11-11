package com.example.todone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.btn_0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGstartedListener()
    }

    private fun btnGstartedListener() {
        btn_0.setOnClickListener {
            startActivity(Intent(this, SignActivity::class.java))

        }
    }
}