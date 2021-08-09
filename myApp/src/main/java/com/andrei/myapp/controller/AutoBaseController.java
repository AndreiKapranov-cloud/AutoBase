package com.andrei.myapp.controller;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AutoBaseController {
    private final AutoBaseDtoService autoBaseDtoService;

    public AutoBaseController(AutoBaseDtoService autoBaseDtoService) {
        this.autoBaseDtoService = autoBaseDtoService;
    }

    @GetMapping("/autoBaseDtos")
    public String showAutoBaseList(Model model) {
        List<AutoBaseDto>autoBaseDtos = autoBaseDtoService.getAll();
        model.addAttribute("autoBaseDtos",autoBaseDtos);
        return "autoBaseDtos";
    }


    @GetMapping("/autoBaseDto/new")
    public String showAddAutoBaseForm(Model model) {
        model.addAttribute("autoBaseDto", new AutoBaseDto());
        return "autoBaseDto_form";

    }

    @PostMapping("autoBaseDto/save")
    public String saveUserDto(AutoBaseDto autoBaseDto) {
        autoBaseDtoService.save(autoBaseDto);
        return "redirect:/";
    }

    @GetMapping("/autoBaseDtos/edit/{autoBaseId}")
    public String showEditAutoBaseForm(@PathVariable("autoBaseId") Long autoBaseId, Model model) {
        AutoBaseDto autoBaseDto = autoBaseDtoService.getAutoBaseByAutoBaseId(autoBaseId);
        model.addAttribute("autoBaseDto",autoBaseDto);
        return "autoBaseDto_form";

    }
}
