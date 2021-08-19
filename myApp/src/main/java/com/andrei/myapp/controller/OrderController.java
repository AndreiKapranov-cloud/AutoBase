package com.andrei.myapp.controller;

import com.andrei.myapp.dto.*;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderDtoService orderDtoService;
    private final UserService userService;
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;
    private final AutoDtoService autoDtoService;
    private final TripDtoService tripDtoService;

    @GetMapping("admin/orderDtos")
    public String showOrderList(Model model) {
        List<OrdersDto> orderDtos = orderDtoService.getAll();
        model.addAttribute("orderDtos", orderDtos);
        return "adminOrderDtos";
    }

    @GetMapping("/admin/orderDto/new")
    public String showAddOdrerForm(Model model) {
        model.addAttribute("ordersDto", new OrdersDto());
        return "orderDto_form";
    }

    @PostMapping("/admin/orderDto/save")
    public String saveOrder(OrdersDto ordersDto) {
        logger.info("Saving ordersDto");
        orderDtoService.save(ordersDto);
        return "redirect:/";
    }

    @GetMapping("/admin/orderDtos/edit/{orderId}")
    public String showEditUserForm(@PathVariable("orderId") Long orderId, Model model) {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        model.addAttribute("autoBaseDtos",autoBaseDtos);
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
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        model.addAttribute("autoBaseDtos",autoBaseDtos);
        model.addAttribute("ordersDto", new OrdersDto());
        return "dispatcherOrderDto_form";
    }
    @PostMapping("dispatcher/orderDto/save")
    public String saveDispatcherOrder(OrdersDto ordersDto) {
        logger.info("Saving ordersDto");
        orderDtoService.save(ordersDto);
        return "redirect:/dispatcher";
    }
    @GetMapping("/dispatcher/orderDtos/edit/{orderId}")
    public String showDispatcherEditUserForm(@PathVariable("orderId") Long orderId, Model model) {
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        model.addAttribute("autoBaseDtos",autoBaseDtos);
        model.addAttribute("ordersDto", ordersDto);
        return "dispatcherOrderDto_form";
    }
}
