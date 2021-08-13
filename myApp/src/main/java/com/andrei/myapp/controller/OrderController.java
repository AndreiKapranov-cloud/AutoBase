package com.andrei.myapp.controller;

import com.andrei.myapp.dto.*;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.service.interfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {
    private final OrderDtoService orderDtoService;
    private final UserService userService;
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;
    private final AutoDtoService autoDtoService;

    private final TripDtoService tripDtoService;
    public OrderController(OrderDtoService orderDtoService, UserService userService, UserDtoService userDtoService, AutoBaseDtoService autoBaseDtoService, RoleDtoService roleDtoService, AutoDtoService autoDtoService, TripDtoService tripDtoService) {
        this.orderDtoService = orderDtoService;
        this.userService = userService;
        this.userDtoService = userDtoService;
        this.autoBaseDtoService = autoBaseDtoService;
        this.roleDtoService = roleDtoService;
        this.autoDtoService = autoDtoService;
        this.tripDtoService = tripDtoService;
    }

    @GetMapping("admin/orderDtos")
    public String showOrderList(Model model) {
        List<OrdersDto> orderDtos = orderDtoService.getAll();
        model.addAttribute("orderDtos", orderDtos);
        return "orderDtos";
    }




    @GetMapping("/admin/orderDto/new")
    public String showAddOdrerForm(Model model) {
        model.addAttribute("ordersDto", new OrdersDto());
        return "orderDto_form";
    }

    @PostMapping("/admin/orderDto/save")
    public String saveOrder(OrdersDto ordersDto) {
        orderDtoService.save(ordersDto);
        return "redirect:/";
    }

    @GetMapping("/admin/orderDtos/edit/{orderId}")
    public String showEditUserForm(@PathVariable("orderId") Long orderId, Model model) {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        model.addAttribute("ordersDto", ordersDto);
        return "orderDto_form";
    }
    @GetMapping("/dispatcher/orderDtos")
    public String showDispatcherOrderList(Model model) {
        List<OrdersDto> orderDtos = orderDtoService.getAll();
        model.addAttribute("orderDtos", orderDtos);
        return "orderDtos";
    }
    @GetMapping("/dispatcher/orderDto/new")
    public String showDispatcherAddOdrerForm(Model model) {
        model.addAttribute("ordersDto", new OrdersDto());
        return "dispatcherOrderDto_form";
    }
    @PostMapping("dispatcher/orderDto/save")
    public String saveDispatcherOrder(OrdersDto ordersDto) {
        orderDtoService.save(ordersDto);
        return "redirect:/dispatcher";
    }
    @GetMapping("/dispatcher/orderDtos/edit/{orderId}")
    public String showDispatcherEditUserForm(@PathVariable("orderId") Long orderId, Model model) {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        model.addAttribute("ordersDto", ordersDto);
        return "dispatcherOrderDto_form";
    }
}