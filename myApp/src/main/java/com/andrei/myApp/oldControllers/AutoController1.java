package com.andrei.myApp.oldControllers;

import com.andrei.myApp.service.serviceInterfaces.AutoService;
import org.springframework.stereotype.Controller;

@Controller

public class AutoController1 {

    private final AutoService autoService;

    public AutoController1(AutoService autoService) {
        this.autoService = autoService;
    }


 /*  @PostMapping("/addauto")
    public String addAuto(AutoDto autoDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addauto";
        }

        autoService.save(autoDto);
        return "redirect:/index-auto";
    }

    @GetMapping("/autos")
    public String showAutoList(Model model) {
        model.addAttribute("autos", autoService.getAll());
        return "autos";
    }

    @GetMapping("/edit/{autoId}")
    public String showUpdateForm(@PathVariable("autoId") Long autoId, Model model) {
        AutoDto autoDto = autoService.getAutoByAutoId(autoId);
        //     .orElseThrow(() -> new IllegalArgumentException("Invalid auto Id:" + autoId));
        model.addAttribute("auto", autoDto);
        return "update-auto";
    }

    @PostMapping("/update/{id}")
    public String updateAuto(@PathVariable("id") Long autoId, AutoDto autoDto,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            autoDto.setAutoId(autoId);
            return "update-auto";
        }

        autoService.save(autoDto);
        return "redirect:/autos";
    }



    @GetMapping("/autoByNumber")
    public AutoDto getAutoByNumber(@RequestParam String number) {
        return autoService.getAutoByNumber(number);
    }

    @GetMapping("/autosByCarryingCapacity")
    public List<AutoDto> getAutosByCarryingCapacity(@RequestParam int carryingCapacity) {
        return autoService.getAutosByCarryingCapacityIsGreaterThan(carryingCapacity);
    }

    @GetMapping("/autosByMaxWeightWithCargoKg")
    public List<AutoDto> getAutosByMaxWeightWithCargoKgIsLessThan(@RequestParam int maxWeightWithCargoKg) {
        return autoService.getAutosByMaxWeightWithCargoKgIsLessThan(maxWeightWithCargoKg);
    }

    @GetMapping("/autosByMaxVolumeM3After")
    public List<AutoDto> getAutosByMaxVolumeM3After(@RequestParam int maxVolumeM3) {
        return autoService.getAutosByMaxVolumeM3After(maxVolumeM3);
    }

    @GetMapping("/autosByTechnicalInspection")
    public List<AutoDto> getAutosByTechnicalInspection(@RequestParam int technicalInspection) {
        return autoService.getAutosByMaxVolumeM3After(technicalInspection);
    }

    @PostMapping("/addAuto")
    public Auto save(@RequestBody AutoDto autoDto) {
        return autoService.save(autoDto);
    }*/
}
