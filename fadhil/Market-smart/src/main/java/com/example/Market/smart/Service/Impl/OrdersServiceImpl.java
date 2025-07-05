package com.example.Market.smart.Service.Impl;

import com.example.Market.smart.Model.Orders;
import com.example.Market.smart.Repository.OrdersRepository;
import com.example.Market.smart.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders placeOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public List<Orders> getOrdersByBuyerId(Long buyerId) {
        return ordersRepository.findAll();
    }

    @Override
    public Orders getOrdersById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }
    @Override
    public void cancelOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
