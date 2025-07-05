package com.example.Market.smart.Service;

import com.example.Market.smart.Model.Orders;

import java.util.List;


public interface OrdersService {
    Orders placeOrder(Orders order);
    List<Orders> getOrdersByBuyerId(Long buyerId);
    Orders getOrdersById(Long id);
    void cancelOrder(Long id);

}
