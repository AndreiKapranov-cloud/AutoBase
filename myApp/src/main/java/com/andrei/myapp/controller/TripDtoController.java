package com.andrei.myapp.controller;

import com.andrei.myapp.dto.*;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TripDtoController {

    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;
    private final AutoDtoService autoDtoService;
    private final OrderDtoService orderDtoService;
    private final TripDtoService tripDtoService;

    public TripDtoController(UserDtoService userDtoService, AutoBaseDtoService autoBaseDtoService, RoleDtoService roleDtoService, AutoDtoService autoDtoService, OrderDtoService orderDtoService, TripDtoService tripDtoService) {
        this.userDtoService = userDtoService;
        this.autoBaseDtoService = autoBaseDtoService;
        this.roleDtoService = roleDtoService;
        this.autoDtoService = autoDtoService;
        this.orderDtoService = orderDtoService;
        this.tripDtoService = tripDtoService;
    }

    @GetMapping("/tripDtos")
    public String showTripList(Model model) {
        List<TripDto> tripDtos = tripDtoService.getAll();
        model.addAttribute("tripDtos", tripDtos);
        return "tripDtos";
    }

    @GetMapping("/requestTripDto/new")
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

    @PostMapping("requestTripDto/save")
    public String saveRequestTripDto(RequestTripDto requestTripDto) {
        tripDtoService.save(requestTripDto);
        return "redirect:/";
    }

    @GetMapping("/tripDtos/edit/{tripId}")
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