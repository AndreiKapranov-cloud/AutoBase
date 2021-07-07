package com.andrei.myApp.oldControllers;

import com.andrei.myApp.model.dao.UserDao;
import com.andrei.myApp.service.serviceInterfaces.UserService;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {
    private final UserService userService;
    private final UserDao dao;
    public UserController(UserService userService, UserDao dao) {
        this.userService = userService;
        this.dao = dao;
    }

  /*  @GetMapping("/signup")
    public String showSignUpForm(UserDto userDto) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.save(userDto);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", dao.findAll());
        return "indexuser";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long userId, Model model) {
        UserDto userDto= userService.getUserById(userId);
     //     .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        model.addAttribute("user", userDto);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long userId, UserDto userDto,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            userDto.setUserId(userId);
            return "update-user";
        }

        userService.save(userDto);
        return "redirect:/index";
    }

   /* @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long userId, Model model) {
        UserDto userDto = userService.getUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        userservice.delete(userDto);
        return "redirect:/index";
    }*/
}


