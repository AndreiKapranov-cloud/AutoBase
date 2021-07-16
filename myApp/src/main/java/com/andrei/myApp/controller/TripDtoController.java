package com.andrei.myApp.controller;

import com.andrei.myApp.dto.*;
import com.andrei.myApp.service.serviceInterfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/tripDto/new")
    public String showAddTripForm(Model model) {

        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<UserDto> userDtos = userDtoService.getAll();
        List<AutoDto> autoDtos = autoDtoService.getAll();
        List<OrdersDto> ordersDtos = orderDtoService.getAll();

        model.addAttribute("tripDto", new TripDto());
        model.addAttribute("ordersDtos", ordersDtos);
        model.addAttribute("userDtos", userDtos);
        model.addAttribute("autoDtos", autoDtos);
        model.addAttribute("autoBaseDtos", autoBaseDtos);

        return "tripDto_form";

    }

    @PostMapping("tripDto/save")
    public String saveTripDto(TripDto tripDto) {
        tripDtoService.save(tripDto);

        return "redirect:/";
    }
}