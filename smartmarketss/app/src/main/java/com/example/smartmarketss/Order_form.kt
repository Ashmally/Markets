package com.example.smartmarketss

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class OrderForm : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_form)

        val productId = findViewById<EditText>(R.id.ProductId)
        val price = findViewById<EditText>(R.id.PriceId)
        val quantity = findViewById<EditText>(R.id.QuantityId)
        val btnSave = findViewById<Button>(R.id.SaveOrder)

        btnSave.setOnClickListener {
            Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }
    }
}
