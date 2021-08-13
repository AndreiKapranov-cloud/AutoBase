package com.andrei.myapp.controller;

import com.andrei.myapp.dto.*;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.service.interfaces.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;

@Controller
public class TripController {
    private final UserService userService;
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;
    private final AutoDtoService autoDtoService;
    private final OrderDtoService orderDtoService;
    private final TripDtoService tripDtoService;

    public TripController(UserService userService, UserDtoService userDtoService, AutoBaseDtoService autoBaseDtoService, RoleDtoService roleDtoService, AutoDtoService autoDtoService, OrderDtoService orderDtoService, TripDtoService tripDtoService) {
        this.userService = userService;
        this.userDtoService = userDtoService;
        this.autoBaseDtoService = autoBaseDtoService;
        this.roleDtoService = roleDtoService;
        this.autoDtoService = autoDtoService;
        this.orderDtoService = orderDtoService;
        this.tripDtoService = tripDtoService;
    }


    @GetMapping("admin/tripDtos")
    public String showTripList(Model model) {
        List<TripDto> tripDtos = tripDtoService.getAll();
        model.addAttribute("tripDtos", tripDtos);
        return "tripDtos";
    }

    @GetMapping("/driver/tripDtos")
    public String showDriversTripList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User driver = userService.getUserByUsername(userName);
        List<TripDto> tripDtos = tripDtoService.getTripsByDriver(driver);
        model.addAttribute("tripDtos", tripDtos);
        return "tripDtos";
    }

    @GetMapping("/dispatcher/tripDtos/edit/{tripId}")
    public String showEditDispatchersTripForm(@PathVariable("tripId") Long tripId, Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<OrdersDto> ordersDtos = orderDtoService.getAll();
        List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
        List<UserDto> dispatchers = userDtoService.getUsersByRoleRolEnum(RolEnum.DISPATCHER);
        RequestTripDto requestTripDto = tripDtoService.getTripByTripId(tripId);
        model.addAttribute("requestTripDto", requestTripDto);
        model.addAttribute("ordersDtos", ordersDtos);
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("drivers", drivers);
        model.addAttribute("dispatchers", dispatchers);
        return "dispatcherTripDto_form";
    }

    @GetMapping("/dispatcher/tripDtos")
    public String showDispatchersTripList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User dispatcher = userService.getUserByUsername(userName);
        List<TripDto> tripDtos = tripDtoService.getTripsByDispatcher(dispatcher);
        model.addAttribute("tripDtos", tripDtos);
        return "tripDtos";
    }

    @GetMapping("/driver/tripDtos/edit/{tripId}")
    public String showEditDriversTripForm(@PathVariable("tripId") Long tripId, Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<OrdersDto> ordersDtos = orderDtoService.getAll();
        List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
        List<UserDto> dispatchers = userDtoService.getUsersByRoleRolEnum(RolEnum.DISPATCHER);
        RequestTripDto requestTripDto = tripDtoService.getTripByTripId(tripId);
        model.addAttribute("requestTripDto", requestTripDto);
        model.addAttribute("ordersDtos", ordersDtos);
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("drivers", drivers);
        model.addAttribute("dispatchers", dispatchers);
        return "driverTripDto_form";
    }

    @GetMapping("admin/requestTripDto/new")
    public String showAddTripForm(Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<OrdersDto> ordersDtos = orderDtoService.getAll();
        List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
        List<UserDto> dispatchers = userDtoService.getUsersByRoleRolEnum(RolEnum.DISPATCHER);
        model.addAttribute("requestTripDto", new RequestTripDto());
        model.addAttribute("ordersDtos", ordersDtos);
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("drivers", drivers);
        model.addAttribute("dispatchers", dispatchers);
        return "tripDto_form";

    }

    @GetMapping("admin/requestTripDtoByOrder/new/{orderId}")
    public String showAddTripByOrderForm(@PathVariable("orderId") Long orderId, Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
        List<UserDto> drivers = userDtoService.
                getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThanAndAuto_maxVolumeM3IsGreaterThan
                        (UserEnum.READY, ordersDto.getWeight(), ordersDto.getVolumeM3());
        List<UserDto> dispatchers = userDtoService.getUsersByRoleRolEnum(RolEnum.DISPATCHER);
        model.addAttribute("requestTripDto", new RequestTripDto());
        model.addAttribute("ordersDtos", ordersDto);
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("drivers", drivers);
        model.addAttribute("dispatchers", dispatchers);
        return "tripDtoByOrder_form";
    }

    @GetMapping("dispatcher/requestTripDto/new")
    public String showAddDispatcherTripForm(Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<OrdersDto> ordersDtos = orderDtoService.getAll();
        List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
        List<UserDto> dispatchers = userDtoService.getUsersByRoleRolEnum(RolEnum.DISPATCHER);
        model.addAttribute("requestTripDto", new RequestTripDto());
        model.addAttribute("ordersDtos", ordersDtos);
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("drivers", drivers);
        model.addAttribute("dispatchers", dispatchers);
        return "dispatcherTripDto_form";

    }

    @PostMapping("admin/requestTripDto/save")
    public String saveRequestTripDto(RequestTripDto requestTripDto) {
        tripDtoService.save(requestTripDto);
        return "redirect:/";
    }

    @PostMapping("driver/requestTripDto/save")
    public String saveDriversRequestTripDto(RequestTripDto requestTripDto) {
        tripDtoService.save(requestTripDto);
        return "redirect:/driver";
    }

    @PostMapping("dispatcher/requestTripDto/save")
    public String saveDispatchersRequestTripDto(RequestTripDto requestTripDto) {
        tripDtoService.save(requestTripDto);
        return "redirect:/dispatcher";
    }

    @GetMapping("/admin/tripDtos/edit/{tripId}")
    public String showEditTripForm(@PathVariable("tripId") Long tripId, Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<OrdersDto> ordersDtos = orderDtoService.getAll();
        List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
        List<UserDto> dispatchers = userDtoService.getUsersByRoleRolEnum(RolEnum.DISPATCHER);
        RequestTripDto requestTripDto = tripDtoService.getTripByTripId(tripId);
        model.addAttribute("requestTripDto", requestTripDto);
        model.addAttribute("ordersDtos", ordersDtos);
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("drivers", drivers);
        model.addAttribute("dispatchers", dispatchers);
        return "tripDto_form";
    }
}