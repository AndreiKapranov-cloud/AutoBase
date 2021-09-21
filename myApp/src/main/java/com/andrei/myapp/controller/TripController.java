package com.andrei.myapp.controller;

import com.andrei.myapp.dto.*;
import com.andrei.myapp.google.GetDistanceMatrixApi;
import com.andrei.myapp.mapper.TripToRequestTripDtoMapperImpl;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequiredArgsConstructor
public class TripController {
    Logger logger = LoggerFactory.getLogger(TripController.class);
    private final UserService userService;
    private final UserDtoService userDtoService;
    private final AutoBaseDtoService autoBaseDtoService;
    private final RoleDtoService roleDtoService;
    private final AutoDtoService autoDtoService;
    private final OrderDtoService orderDtoService;
    private final TripDtoService tripDtoService;
    private final TripToRequestTripDtoMapperImpl mapper;
    private final GetDistanceMatrixApi getDistanceMatrixApi;
    private final OrderService orderService;

    @GetMapping("admin/tripDtos")
    public String showTripList(Model model) {
        List<TripDto> tripDtos = tripDtoService.getAll();
        model.addAttribute("tripDtos", tripDtos);
        return "tripDtos";
    }

    @GetMapping("/driver/tripDtos")
    public String showDriversTripList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        User driver = userService.getUserByLogin(login);
        List<TripDto> tripDtos = tripDtoService.getTripsByDriver(driver);
        model.addAttribute("tripDtos", tripDtos);
        return "tripDtos";
    }

    @GetMapping("/dispatcher/tripDtos/edit/{tripId}")
    public String showEditDispatchersTripForm(@PathVariable("tripId") Long tripId, Model model) {
        RequestTripDto requestTripDto = tripDtoService.getRequestTripDtoByTripId(tripId);
        duplicationSlayer(model);
        model.addAttribute("requestTripDto", requestTripDto);


        return "dispatcherTripDto_form";
    }

    @GetMapping("/dispatcher/tripDtos")
    public String showDispatchersTripList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        User dispatcher = userService.getUserByLogin(login);
        List<TripDto> tripDtos = tripDtoService.getTripsByDispatcher(dispatcher);
        model.addAttribute("tripDtos", tripDtos);
        return "tripDtos";
    }

    @GetMapping("/driver/tripDtos/edit/{tripId}")
    public String showEditDriversTripForm(@PathVariable("tripId") Long tripId, Model model) throws Exception {
        RequestTripDto requestTripDto = tripDtoService.getRequestTripDtoByTripId(tripId);
        UserDto driver1 = userDtoService.getDriver(Long.valueOf(requestTripDto.getDriver()));
        String driver = String.valueOf(driver1.getUserId());
        Long orderId = Long.valueOf(requestTripDto.getOrders());
        duplicationReducer(orderId,model);
        model.addAttribute("driver", driver);
        model.addAttribute("requestTripDto", requestTripDto);
        return "tripDtoByOrderDriver_form";
    }

    @GetMapping("admin/requestTripDto/new")
    public String showAddTripForm(Model model) {
        duplicationSlayer(model);
        model.addAttribute("requestTripDto", new RequestTripDto());
        return "tripDto_form";

    }


private void duplicationSlayer (Model model){
    List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
    List<OrdersDto> ordersDtos = orderDtoService.getAll();
    List<UserDto> drivers = userDtoService.getUsersByRoleRolEnum(RolEnum.DRIVER);
    List<UserDto> dispatchers = userDtoService.getUsersByRoleRolEnum(RolEnum.DISPATCHER);
    model.addAttribute("ordersDtos", ordersDtos);
    model.addAttribute("autoBaseDtos", autoBaseDtos);
    model.addAttribute("drivers", drivers);
    model.addAttribute("dispatchers", dispatchers);
}
private void duplicationReducer(@PathVariable("orderId") Long orderId, Model model)throws Exception {
    List<AutoBaseDto> autoBaseDtos = autoBaseDtoService.getAll();
    String dispatcher = tripDtoService.tripDispatcherHelper();
    String orders = String.valueOf(orderId);
    List<UserDto> drivers = tripDtoService.tripDriversHelper(orderId);
    String tripStatus = "waiting";
    OrdersDto ordersDto = orderDtoService.getOrdersByOrderId(orderId);
    String deliveryAddress = ordersDto.getDeliveryAddress();
    String start = (ordersDto.getAutoBase()).getAddress();
    long distanceKm = tripDtoService.tripGetDistanceKm(orderId);
    model.addAttribute("tripStatus", tripStatus);
    model.addAttribute("dispatcher", dispatcher);
    model.addAttribute("start", start);
    model.addAttribute("deliveryAddress", deliveryAddress);
    model.addAttribute("distanceKm", distanceKm);
    model.addAttribute("orders", orders);
    model.addAttribute("autoBaseDtos", autoBaseDtos);
    model.addAttribute("drivers", drivers);
}

    @GetMapping("dispatcher/requestTripDtoByOrder/new/{orderId}")
    public String showAddTripByOrdersForm(@PathVariable("orderId") Long orderId, Model model) throws Exception {
        duplicationReducer(orderId,model);
        model.addAttribute("requestTripDto", new RequestTripDto());
        return "tripDtoByOrder_form";
    }


    @PostMapping("dispatcher/requestTripDto/save")
    public String saveDispRequestTripDto(RequestTripDto requestTripDto) throws Exception {
        logger.info("Saving tripDto");
        tripDtoService.save(requestTripDto);
        return "redirect:/dispatcher";
    }


    @PostMapping("admin/requestTripDto/save")
    public String saveRequestTripDto(RequestTripDto requestTripDto) {
        logger.info("Saving tripDto");
        tripDtoService.save(requestTripDto);
        return "redirect:/";
    }


    @PostMapping("driver/requestTripDto/save")
    public String saveDriversRequestTripDto(RequestTripDto requestTripDto) {
        logger.info("Saving tripDto");
        tripDtoService.save(requestTripDto);
        return "redirect:/driver";
    }


    @GetMapping("/admin/tripDtos/edit/{tripId}")
    public String showEditTripForm(@PathVariable("tripId") Long tripId, Model model) {
        RequestTripDto requestTripDto = tripDtoService.getRequestTripDtoByTripId(tripId);
        duplicationSlayer(model);
        model.addAttribute("requestTripDto", requestTripDto);
        return "tripDto_form";
    }


}