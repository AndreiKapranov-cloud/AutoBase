package com.andrei.myapp.controller;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.dto.RequestUserDto;
import com.andrei.myapp.dto.RoleDto;
import com.andrei.myapp.dto.UserDto;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class AutoBaseController {
    private final AutoBaseDtoService autoBaseDtoService;
    @GetMapping("admin/autoBaseDtos")
    public String showAutoBaseList(Model model) {
        List<AutoBaseDto>autoBaseDtos = autoBaseDtoService.getAll();
        model.addAttribute("autoBaseDtos",autoBaseDtos);
        return "autoBaseDtos";
    }


    @GetMapping("admin/autoBaseDto/new")
    public String showAddAutoBaseForm(Model model) {
        model.addAttribute("autoBaseDto", new AutoBaseDto());
        return "autoBaseDto_form";

    }

    @PostMapping("admin/autoBaseDto/save")
    public String saveAutoBaseDto(AutoBaseDto autoBaseDto) {
        autoBaseDtoService.save(autoBaseDto);
        return "redirect:/";
    }

    @GetMapping("admin/autoBaseDtos/edit/{autoBaseId}")
    public String showEditAutoBaseForm(@PathVariable("autoBaseId") Long autoBaseId, Model model) {
        AutoBaseDto autoBaseDto = autoBaseDtoService.getAutoBaseByAutoBaseId(autoBaseId);
        model.addAttribute("autoBaseDto",autoBaseDto);
        return "autoBaseDto_form";

    }
}
