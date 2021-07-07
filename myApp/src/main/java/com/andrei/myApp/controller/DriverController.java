package com.andrei.myApp.controller;

import com.andrei.myApp.dto.DriverDto;
import com.andrei.myApp.service.serviceInterfaces.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public String showDriverList(Model model) {
        List<DriverDto> driverDtos = driverService.getAll();
        model.addAttribute("driverDtos", driverDtos);
        return "drivers";
    }

    @GetMapping("/driver/new")
    public String showAddDriverForm(Model model) {
        model.addAttribute("driverDto", new DriverDto());

        return "driverDto_form";
    }

    @PostMapping("/driver/save")
    public String saveDriver(DriverDto driverDto) {
        driverService.save(driverDto);

        return "redirect:/";
    }
}

