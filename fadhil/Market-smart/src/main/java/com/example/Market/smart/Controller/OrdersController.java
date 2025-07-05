package com.example.Market.smart.Controller;

import com.example.Market.smart.Model.Orders;
import com.example.Market.smart.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public Orders placeOrders(@RequestBody Orders order) {
        return ordersService.placeOrder(order);
    }

    @GetMapping("/buyer/{buyerId}")
    public List<Orders> getOrdersByBuyer(@PathVariable Long buyerId) {
        return ordersService.getOrdersByBuyerId(buyerId);
    }

    @GetMapping("/{id}")
    public Orders getOrder(@PathVariable Long id) {
        return ordersService.getOrdersById(id);
    }

    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable Long id) {
        ordersService.cancelOrder(id);
    }
}
