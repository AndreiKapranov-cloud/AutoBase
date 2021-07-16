package com.andrei.myApp.controller;

import com.andrei.myApp.dto.OrdersDto;
import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.model.entity.Orders;
import com.andrei.myApp.service.serviceInterfaces.OrderDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
      model.addAttribute("orderDto", new OrdersDto());
      return "orderDto_form";
  }
        @PostMapping("/orderDto/save")
        public String saveOrder (OrdersDto ordersDto){
            orderDtoService.save(ordersDto);
            return "redirect:/";
        }
    }
