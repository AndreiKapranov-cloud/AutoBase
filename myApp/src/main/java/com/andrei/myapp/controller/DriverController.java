package com.andrei.myapp.controller;

import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.UserDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class DriverController {
    private final UserDtoService userDtoService;

    @GetMapping("admin/drivers")
    public String showDriversList(Model model) {
        List<UserDto>drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
        model.addAttribute("drivers",drivers);
        return "listOfDrivers";
    }

}
