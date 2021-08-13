package com.andrei.myapp.controller;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.enums.UserEnum;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import com.andrei.myapp.service.interfaces.RoleDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;

    public UserController(UserDtoService userDtoService, AutoBaseDtoService autoBaseDtoService, RoleDtoService roleDtoService) {
        this.userDtoService = userDtoService;
        this.autoBaseDtoService = autoBaseDtoService;
        this.roleDtoService = roleDtoService;
    }

    @GetMapping("admin/userDtos")
    public String showUserList(Model model) {
        List<UserDto>userDtos = userDtoService.getAll();
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
        model.addAttribute("userDto", userDto);
        List<RoleDto> roleDtos = roleDtoService.getAll();
        model.addAttribute("roleDtos", roleDtos);
        return "userDto_form";

    }

    @PostMapping("admin/userDto/saveWhenEdit")
    public String saveWhenEditUserDto(RequestUserDto requestUserDto) {
        userDtoService.saveWhenEdit(requestUserDto);
        return "redirect:/";
    }
    @GetMapping("/dispatcher")
    public String redirect(Model model){
        return "dispatcher";
    }
    @GetMapping("/driver")
    public String redirectt(Model model){
        return "driver";
    }
}
