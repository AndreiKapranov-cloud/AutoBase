package com.andrei.myapp.controller;

import com.andrei.myapp.dto.AutoDto;
import com.andrei.myapp.dto.RequestAutoDto;
import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.AutoDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AutoController {
    private final AutoDtoService autoDtoService;
    private final UserDtoService userDtoService;

    @GetMapping("admin/autoDtos")
    public String showAutoList(Model model) {
        List<AutoDto> autoDtos = autoDtoService.getAll();
        model.addAttribute("autoDtos", autoDtos);
        return "autoDtos";
    }

    @GetMapping("admin/autoDto/new")
    public String showAddAutoForm(Model model) {
        List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
        model.addAttribute("autoDto", new AutoDto());
        model.addAttribute("drivers", drivers);
        return "autoDto_form";
    }

    @PostMapping("admin/autoDto/save")
    public String saveAuto(RequestAutoDto requestAutoDto) {
        autoDtoService.save(requestAutoDto);
        return "redirect:/";
    }

    @GetMapping("admin/autoDtos/edit/{autoId}")
    public String showEditAutoForm(@PathVariable("autoId") Long autoId, Model model) {
        AutoDto autoDto = autoDtoService.getAutoByAutoId(autoId);
        List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);;
        model.addAttribute("drivers",drivers);
        model.addAttribute("autoDto", autoDto);
        return "autoDto_form";

    }
}
