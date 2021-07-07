package com.andrei.myApp.controller;

import com.andrei.myApp.dto.AutoDto;
import com.andrei.myApp.service.serviceInterfaces.AutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AutoController {
    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/autos")
    public String showAutoList(Model model) {
        List<AutoDto> autoDtos = autoService.getAll();
        model.addAttribute("autoDtos", autoDtos);
        return "autos";
    }

    @GetMapping("/auto/new")
    public String showAddAutoForm(Model model) {
        model.addAttribute("autoDto", new AutoDto());

        return "autoDto_form";
    }

    @PostMapping("/auto/save")
    public String saveAuto(AutoDto autoDto) {
        autoService.save(autoDto);

        return "redirect:/";
    }
}
