package com.example.smartmarketss

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class productform : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_form)

        val name = findViewById<EditText>(R.id.NameId)
        val price = findViewById<EditText>(R.id.PriceId)
        val quantity = findViewById<EditText>(R.id.QuantityId)
        val btnSave = findViewById<Button>(R.id.btnSaveProduct)

        btnSave.setOnClickListener {
            val productName = name.text.toString()
            val productPrice = price.text.toString().toDoubleOrNull() ?: 0.0
            val productQuantity = quantity.text.toString().toIntOrNull() ?: 0

            if(productName.isBlank()){
                Toast.makeText(this, "Please enter product name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create intent to pass data back
            val intent = Intent(this, product_lists::class.java).apply {
                putExtra("name", productName)
                putExtra("price", productPrice)
                putExtra("quantity", productQuantity)
            }

            Toast.makeText(this, "Product saved", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}
