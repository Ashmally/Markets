package com.example.smartmarketss

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Login : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnlogin)
        btnLogin.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }
    }
}
