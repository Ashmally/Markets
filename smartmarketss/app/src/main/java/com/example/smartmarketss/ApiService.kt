package com.example.smartmarketss.api

import com.example.smartmarketss.entities.Orderap
import com.example.smartmarketss.entities.Productap
import com.example.smartmarketss.entities.Users
import com.example.smartmarketss.models.ApiResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @POST("register")
    fun registerUser(@Body user: Users): Call<ApiResponse>

    @POST("login")
    fun loginUser(@Body loginRequest: Map<String, String>): Call<ApiResponse>



    @GET("products")
    fun getAllProducts(): Call<List<Productap>>

    @GET("products/{id}")
    fun getProductById(@Path("id") id: Long): Call<Productap>

    @POST("products")
    fun addProduct(@Body product: Productap): Call<ApiResponse>

    @PUT("products/{id}")
    fun updateProduct(@Path("id") id: Long, @Body product: Productap): Call<ApiResponse>

    @DELETE("products/{id}")
    fun deleteProduct(@Path("id") id: Long): Call<ApiResponse>

    @GET("products/seller/{sellerId}")
    fun getProductsBySeller(@Path("sellerId") sellerId: Long): Call<List<Productap>>



    @GET("orders")
    fun getAllOrders(): Call<List<Orderap>>

    @GET("orders/{id}")
    fun getOrderById(@Path("id") id: Long): Call<Orderap>

    @GET("orders/buyer/{buyerId}")
    fun getOrdersByBuyer(@Path("buyerId") buyerId: Long): Call<List<Orderap>>

    @GET("orders/seller/{sellerId}")
    fun getOrdersBySeller(@Path("sellerId") sellerId: Long): Call<List<Orderap>>

    @POST("orders")
    fun placeOrder(@Body order: Orderap): Call<ApiResponse>

    @PUT("orders/{id}")
    fun updateOrder(@Path("id") id: Long, @Body order: Orderap): Call<ApiResponse>

    @DELETE("orders/{id}")
    fun deleteOrder(@Path("id") id: Long): Call<ApiResponse>
}
