package com.andrei.myapp.controller;

import com.andrei.myapp.dto.OrdersDto;
import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.service.interfaces.OrderDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderDtoController {
    private final OrderDtoService orderDtoService;

    public OrderDtoController(OrderDtoService orderDtoService) {
        this.orderDtoService = orderDtoService;
    }

    @GetMapping("/orderDtos")
    public String showOrderList(Model model) {
        List<OrdersDto> orderDtos = orderDtoService.getAll();
        model.addAttribute("orderDtos", orderDtos);
        return "orderDtos";
    }

    @GetMapping("/orderDto/new")
    public String showAddOdrerForm(Model model) {
        model.addAttribute("ordersDto", new OrdersDto());
        return "orderDto_form";
    }

    @PostMapping("/orderDto/save")
    public String saveOrder(OrdersDto ordersDto) {
        orderDtoService.save(ordersDto);
        return "redirect:/";
    }

    @GetMapping("/orderDtos/edit/{orderId}")
    public String showEditUserForm(@PathVariable("orderId") Long orderId, Model model) {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        model.addAttribute("ordersDto", ordersDto);
        return "orderDto_form";
    }
}
