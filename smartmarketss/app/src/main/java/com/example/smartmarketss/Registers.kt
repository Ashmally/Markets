package com.example.smartmarketss.Registers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.smartmarketss.Login
import com.example.smartmarketss.R
import com.example.smartmarketss.api.RetrofitClient
import com.example.smartmarketss.entities.Users
import com.example.smartmarketss.models.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : Activity() {

    private lateinit var FullName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var roleSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registers)

        FullName = findViewById(R.id.FullName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        roleSpinner = findViewById(R.id.spinner)

        val roleOptions = arrayOf("Choose role", "Seller", "Buyer")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, roleOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        roleSpinner.adapter = adapter

        val btnRegister = findViewById<Button>(R.id.btnregister)
        btnRegister.setOnClickListener {
            val selectedRole = roleSpinner.selectedItem.toString()

            if (selectedRole == "Choose role") {
                Toast.makeText(this, "Please select a valid role", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = Users(
                id = 0,  // id will be assigned by backend
                FullName = FullName.text.toString().trim(),
                email = email.text.toString().trim(),
                password = password.text.toString().trim(),
                role = selectedRole
            )

            // Simple validation
            if(user.FullName.isEmpty() || user.email.isEmpty() || user.password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Call backend API to register
            RetrofitClient.instance.registerUser(user).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        val res = response.body()
                        if (res != null && res.success) {
                            Toast.makeText(this@RegisterActivity, "Registered Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@RegisterActivity, Login::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@RegisterActivity, "Error: ${res?.message ?: "Unknown error"}", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this@RegisterActivity, "Error ${response.code()}: ${response.errorBody()?.string() ?: "Unknown error"}", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "Network error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }

        val loginBtn = findViewById<Button>(R.id.login)
        loginBtn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}
