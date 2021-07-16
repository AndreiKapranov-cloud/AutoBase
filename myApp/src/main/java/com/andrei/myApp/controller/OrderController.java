package com.andrei.myApp.controller;

import com.andrei.myApp.model.entity.Orders;
import com.andrei.myApp.service.serviceInterfaces.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/orders")
    public String showOrderList(Model model) {
        List<Orders> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "orderDtos";
    }
    @GetMapping("/order/new")
    public String showAddOdrerForm(Model model) {
        model.addAttribute("order", new Orders());
        return "order_form";
    }
    @PostMapping("/order/save")
    public String saveOrder (Orders orders){
        orderService.save(orders);
        return "redirect:/";
    }
}
