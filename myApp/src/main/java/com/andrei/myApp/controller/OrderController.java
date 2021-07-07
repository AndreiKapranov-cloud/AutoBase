package com.andrei.myApp.controller;

import com.andrei.myApp.dto.DispatcherDto;
import com.andrei.myApp.dto.OrderDto;
import com.andrei.myApp.model.entity.*;
import com.andrei.myApp.service.serviceInterfaces.DispatcherService;
import com.andrei.myApp.service.serviceInterfaces.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final DispatcherService dispatcherService;

    public OrderController(OrderService orderService, DispatcherService dispatcherService) {
        this.orderService = orderService;
        this.dispatcherService = dispatcherService;
    }


    @GetMapping("/orders")
    public String showOrderList(Model model) {
        List<OrderDto> orderDtos = orderService.getAll();
        model.addAttribute("orderDtos", orderDtos);
        return "orders";
    }

  /*  @GetMapping("/order/new")
    public String showAddOrderForm(Model model) {
        List<DispatcherDto> dispatcherDtos = dispatcherService.getAll();
        model.addAttribute("orderDto", new OrderDto());
        model.addAttribute("dispatcherDtos", dispatcherDtos);
        return "orderDto_form";
    }*/
  @GetMapping("/order/new")
  public String showAddUserForm(Model model) {
      List<DispatcherDto> dispatchers = dispatcherService.getAll();
      model.addAttribute("order", new Order());
      model.addAttribute("dispatchers", dispatchers);
      return "orderDto_form";

  }
        @PostMapping("/order/save")
        public String saveOrder (Order order){
            orderService.save(order);

            return "redirect:/";
        }
    }