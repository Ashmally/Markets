package com.example.smartmarketss.dao

import androidx.room.*
import com.example.smartmarketss.entities.Users
import com.example.smartmarketss.entities.Productap
import com.example.smartmarketss.entities.Orderap

@Dao
interface SmartMarketDao {

    // ----- Users -----
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: Users)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    suspend fun loginUser(email: String, password: String): Users?

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<Users>

    // ----- Products -----
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Productap)

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<Productap>

    @Delete
    suspend fun deleteProduct(product: Productap)

    // ----- Orders -----
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Orderap)

    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<Orderap>

    @Delete
    suspend fun deleteOrder(order: Orderap)
}
