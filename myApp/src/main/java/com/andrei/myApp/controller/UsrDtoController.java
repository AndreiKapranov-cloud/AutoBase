package com.andrei.myApp.controller;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.dto.RoleDto;
import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.service.serviceInterfaces.AutoBaseDtoService;
import com.andrei.myApp.service.serviceInterfaces.RoleDtoService;
import com.andrei.myApp.service.serviceInterfaces.UserDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsrDtoController {
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;

    public UsrDtoController(UserDtoService userDtoService, AutoBaseDtoService autoBaseDtoService, RoleDtoService roleDtoService) {
        this.userDtoService = userDtoService;
        this.autoBaseDtoService = autoBaseDtoService;
        this.roleDtoService = roleDtoService;
    }

    @GetMapping("/userDtos")
    public String showUserList(Model model) {
        List<UserDto> userDtos = userDtoService.getAll();
        model.addAttribute("userDtos", userDtos);
        return "userDtos";
    }


    @GetMapping("/userDto/new")
    public String showAddUserForm(Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<RoleDto> roleDtos = roleDtoService.getAll();
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("roleDtos", roleDtos);
        model.addAttribute("userDto", new UserDto());

        return "userDto_form";

    }

    @PostMapping("userDto/save")
    public String saveUserDto(UserDto userDto) {
        userDtoService.save(userDto);
        return "redirect:/";
    }

    @GetMapping("/userDtos/edit/{userId}")
    public String showEditUserForm(@PathVariable("userId") Long userId, Model model) {
        UserDto userDto = userDtoService.getUserById(userId);
        model.addAttribute("userDto", userDto);
        List<RoleDto> roleDtos = roleDtoService.getAll();
        model.addAttribute("roleDtos", roleDtos);
        return "userDto_form";

    }
}
