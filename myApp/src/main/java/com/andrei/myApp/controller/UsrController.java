package com.andrei.myApp.controller;

import com.andrei.myApp.dto.AutoBaseDto;
import com.andrei.myApp.dto.UserDto;
import com.andrei.myApp.dto.UserRoleDto;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.service.impl.UserServiceImpl;
import com.andrei.myApp.service.serviceInterfaces.AutoBaseService;
import com.andrei.myApp.service.serviceInterfaces.UserRoleService;
import com.andrei.myApp.service.serviceInterfaces.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsrController {
    private final UserService userService;
    private final AutoBaseService autoBaseService;
    private final UserRoleService userRoleService;

    public UsrController(UserService userService, AutoBaseService autoBaseService, UserRoleService userRoleService) {
        this.userService = userService;
        this.autoBaseService = autoBaseService;
        this.userRoleService = userRoleService;
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<UserDto> userDtos = userService.getAll();
        model.addAttribute("userDtos", userDtos);
        return "users";
    }


    @GetMapping("/user/new")
    public String showAddUserForm(Model model) {

        List<AutoBaseDto> autoBaseDtos = autoBaseService.getAll();
        List<UserRoleDto> userRoleDtos = userRoleService.getAll();
        model.addAttribute("autoBaseDtos", autoBaseDtos);
        model.addAttribute("userRoleDtos", userRoleDtos);
        model.addAttribute("userDto", new UserDto());


        return "userDto_form";

    }

    @PostMapping("user/save")
    public String saveUserDto(UserDto userDto) {
        userService.save(userDto);

        return "redirect:/";
    }

    /*  @GetMapping("/user1/new")
    public String showAddUserForm1(Model model) {
        List<AutoBase>autoBases=autoBaseService.getAll();
        List<UserRole>userRoles=userRoleService.getAll();
        model.addAttribute("autoBases",autoBases);
        model.addAttribute("userRoles",userRoles);
        model.addAttribute("user", new User());

        return "user_form";

    }*/
   /* @PostMapping("/user1/save")
    public String saveUser(User user) {
        userService.save(user);
       return "redirect:/";

   }*/


}
