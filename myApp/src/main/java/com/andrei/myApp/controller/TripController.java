package com.andrei.myApp.controller;

import com.andrei.myApp.model.entity.*;
import com.andrei.myApp.service.serviceInterfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
public class TripController {
    private final UserService userService;
    private final AutoBaseService autoBaseService;
    private final AutoService autoService;
    private final OrderService orderService;
    private final TripService tripService;

    public TripController(UserService userService, AutoBaseService autoBaseService, AutoService autoService, OrderService orderService, TripService tripService) {
        this.userService = userService;
        this.autoBaseService = autoBaseService;

        this.autoService = autoService;
        this.orderService = orderService;
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public String showTripList(Model model) {
        List<Trip> trips = tripService.getAll();
        model.addAttribute("trips", trips);
        return "tripDtos";
    }


    @GetMapping("/trip/new")
    public String showAddTripForm(Model model) {

        List<AutoBase> autoBases = autoBaseService.getAll();
        List<User> users = userService.getAll();
        List<Auto> autos = autoService.getAll();
        List<Orders> orders = orderService.getAll();

        model.addAttribute("trip", new Trip());
        model.addAttribute("orders", orders);
        model.addAttribute("users", users);
        model.addAttribute("autos", autos);
        model.addAttribute("autoBases", autoBases);

        return "trip_form";

    }

    @PostMapping("trip/save")
    public String saveTrip(Trip trip) {
        tripService.save(trip);

        return "redirect:/";
    }
}
