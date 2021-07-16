package com.andrei.myApp.controller;

import com.andrei.myApp.dto.AutoDto;
import com.andrei.myApp.service.serviceInterfaces.AutoDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AutoDtoController {
    private final AutoDtoService autoDtoService;

    public AutoDtoController(AutoDtoService autoDtoService) {
        this.autoDtoService = autoDtoService;
    }

    @GetMapping("/autoDtos")
    public String showAutoList(Model model) {
        List<AutoDto> autoDtos = autoDtoService.getAll();
        model.addAttribute("autoDtos", autoDtos);
        return "autoDtos";
    }

    @GetMapping("/autoDto/new")
    public String showAddAutoForm(Model model) {
        model.addAttribute("autoDto", new AutoDto());

        return "autoDto_form";
    }

    @PostMapping("/autoDto/save")
    public String saveAuto(AutoDto autoDto) {
        autoDtoService.save(autoDto);

        return "redirect:/";
    }
}
