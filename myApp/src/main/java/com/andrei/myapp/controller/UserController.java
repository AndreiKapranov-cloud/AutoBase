package com.andrei.myapp.controller;

import com.andrei.myapp.dto.*;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import com.andrei.myapp.service.interfaces.AutoDtoService;
import com.andrei.myapp.service.interfaces.RoleDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
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
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;
    private final AutoDtoService autoDtoService;

    @GetMapping("admin/userDtos")
    public String showUserList(Model model) {
        List<UserDto> userDtos = userDtoService.getAll();
        //  List<UserDto> userDtos = userDtoService.getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThan(UserEnum.READY,6);
        model.addAttribute("userDtos", userDtos);
        return "userDtos";
    }


    @GetMapping("admin/userDto/new")
    public String showAddUserForm(Model model) {
        List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
        List<RoleDto> roleDtos = roleDtoService.getAll();
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("roleDtos", roleDtos);
        model.addAttribute("userDto", new UserDto());
        return "userDto_form";
    }

    @PostMapping("/admin/userDto/save")
    public String saveUserDto(RequestUserDto requestUserDto) {
        userDtoService.save(requestUserDto);
        return "redirect:/";
    }

    @GetMapping("/admin/userDtos/edit/{userId}")
    public String showEditUserForm(@PathVariable("userId") Long userId, Model model) {
        UserDto userDto = userDtoService.getUserById(userId);
        List<RoleDto> roleDtos = roleDtoService.getAll();
        List<AutoDto> autoDtos = autoDtoService.getAutosByTechnicalInspection(true);
        model.addAttribute("userDto", userDto);
        model.addAttribute("roleDtos", roleDtos);
        model.addAttribute("autoDtos", autoDtos);
        return "userDto_form";

    }

    @PostMapping("admin/userDto/saveWhenEdit")
    public String saveWhenEditUserDto(RequestUserDto requestUserDto) {
        userDtoService.saveWhenEdit(requestUserDto);
        return "redirect:/";
    }

    @GetMapping("/dispatcher")
    public String redirect(Model model) {
        return "dispatcher";
    }

    @GetMapping("/driver")
    public String redirectt(Model model) {
        return "driver";
    }

    @GetMapping("/admin/google")
    public String showGoogleForm(Model model) {
        return "google1";
    }
}
