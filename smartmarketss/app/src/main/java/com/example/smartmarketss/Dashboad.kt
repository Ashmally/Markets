package com.example.smartmarketss

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Dashboard : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboad)

        val dashboardBtn = findViewById<Button>(R.id.Dash)
        val productFormBtn = findViewById<Button>(R.id.Product)
        val orderFormBtn = findViewById<Button>(R.id.Order)
        val productListBtn = findViewById<Button>(R.id.product_lists)

        dashboardBtn.setOnClickListener {

        }

        productFormBtn.setOnClickListener {
            startActivity(Intent(this, productform::class.java))
        }

        orderFormBtn.setOnClickListener {
            startActivity(Intent(this, OrderForm::class.java))
        }

        productListBtn.setOnClickListener {
            startActivity(Intent(this, product_lists::class.java))
        }
    }
}
