package com.andrei.myapp.controller;

import com.andrei.myapp.model.entity.Auto;
import com.andrei.myapp.service.interfaces.AutoService;
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
            List<Auto> autos = autoService.getAll();
            model.addAttribute("autos", autos);
            return "autoDtos";
        }

        @GetMapping("/auto/new")
        public String showAddAutoForm(Model model) {
            model.addAttribute("auto", new Auto());
            return "auto_form";
        }

        @PostMapping("/auto/save")
        public String saveAuto(Auto auto) {
            autoService.save(auto);

            return "redirect:/";
        }
}
