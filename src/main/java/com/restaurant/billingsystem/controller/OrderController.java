package com.restaurant.billingsystem.controller;

import com.restaurant.billingsystem.model.Order;
import com.restaurant.billingsystem.model.Customer;
import com.restaurant.billingsystem.model.Table;
import com.restaurant.billingsystem.service.OrderService;
import com.restaurant.billingsystem.service.CustomerService;
import com.restaurant.billingsystem.service.TableService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private TableService tableService;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public Map<Integer, Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/price/{id}")
    public Double calculateTotalPrice(@PathVariable int id) {
        return orderService.calculateTotalPrice(id);
    }

    @PutMapping("/{orderId}/addItem/{itemId}")
    public Order addItemToOrder(@PathVariable int orderId, @PathVariable int itemId) {
        return orderService.addItemToOrder(orderId, itemId);
    }

    @PutMapping("/{orderId}/addCustomer/{customerId}")
    public Order assignCustomer(@PathVariable int orderId, @PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return orderService.addCustomerToOrder(orderId, customer);
    }

    @PutMapping("/{orderId}/assignTable/{tableId}")
    public Order assignTableToOrder(@PathVariable int orderId, @PathVariable int tableId) {
        Table table = tableService.getTableById(tableId);
        return orderService.assignTableToOrder(orderId, table);
    }
}
