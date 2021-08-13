package com.andrei.myapp.mapper;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.model.entity.Orders;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.TripEnum;
import com.andrei.myapp.model.enums.TripEnumConverter;
import com.andrei.myapp.service.interfaces.AutoBaseService;
import com.andrei.myapp.service.interfaces.OrderService;
import com.andrei.myapp.service.interfaces.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripToRequestTripDtoMapperImplTest {
    @Mock
    private UserService userService;
    @Mock
    private AutoBaseService autoBaseService;
    @Mock
    private OrderService orderService;
    private TripToRequestTripDtoMapperImpl mapper;
    private TripEnumConverter tripEnumConverter;

    private final Long dispatcherId = 1L;
    String dispatcherName = "Fedor";
    private final Long driverId = 2L;
    String driverName = "Uri";
    private final Long autoBaseId = 2L;
    String nameOfOrganization = "OOO";
    String address = "Piushkina,10";
    private final Long orderId = 3L;
    String deliveryAddress = "piushkina,12";

    @Before
    public void init() {
        mapper = new TripToRequestTripDtoMapperImpl(autoBaseService, orderService, userService);

        AutoBase autoBase = new AutoBase();
        Orders orders = new Orders();
        User dispatcher = new User();
        User driver = new User();
        autoBase.setAutoBaseId(autoBaseId);
        autoBase.setNameOfOrganization(nameOfOrganization);
        autoBase.setAddress(address);
        dispatcher.setUserId(dispatcherId);
        dispatcher.setUserName(dispatcherName);
        driver.setUserId(driverId);
        driver.setUserName(driverName);
        orders.setOrderId(orderId);
        orders.setDeliveryAddress(deliveryAddress);


        Mockito.when(userService.getUserById(dispatcherId)).thenReturn(dispatcher);
        Mockito.when(userService.getUserById(driverId)).thenReturn(driver);
        Mockito.when(orderService.getOrdersByOrderId(orderId)).thenReturn(orders);
        Mockito.when(autoBaseService.getAutoBaseByAutoBaseId(autoBaseId)).thenReturn(autoBase);
    }

    @org.junit.Test
    public void givenRequestTripDtoToTrip_whenMaps_thenCorrect() {
        TripEnumConverter tripEnumConverter = new TripEnumConverter();
        RequestTripDto requestTripDto = new RequestTripDto();
        requestTripDto.setTripId(1L);
        requestTripDto.setDistanceKm(54);
        requestTripDto.setTripStatus("stopped");
        requestTripDto.setFuelLitres(50);
        requestTripDto.setOrders("3");
        requestTripDto.setAutoBase("2");
        requestTripDto.setDispatcher("1");
        requestTripDto.setDriver("2");

        Trip trip = mapper.requestTripDtoToTrip(requestTripDto);

        assertEquals(requestTripDto.getTripId(), trip.getTripId());
        assertEquals(requestTripDto.getDistanceKm(), trip.getDistanceKm());
        assertEquals(requestTripDto.getTripStatus(), tripEnumConverter.convertToDatabaseColumn(trip.getTripStatus()));
        assertEquals(requestTripDto.getFuelLitres(), trip.getFuelLitres());
        assertEquals(orderService.getOrdersByOrderId(Long.valueOf(requestTripDto.getOrders())), trip.getOrders());
        assertEquals(autoBaseService.getAutoBaseByAutoBaseId(Long.valueOf(requestTripDto.getAutoBase())),
                trip.getAutoBase());
        assertEquals(userService.getUserById(Long.valueOf(requestTripDto.getDispatcher())), trip.getDispatcher());
        assertEquals(userService.getUserById(Long.valueOf(requestTripDto.getDriver())), trip.getDriver());
    }

    @org.junit.Test
    public void givenTripToRequestTripDto_whenMaps_thenCorrect() {
        TripEnumConverter tripEnumConverter = new TripEnumConverter();
        Trip trip = new Trip();

        trip.setDistanceKm(25);
        trip.setTripStatus(TripEnum.WAITING);
        trip.setFuelLitres(10);
        trip.setOrders(orderService.getOrdersByOrderId(orderId));
        trip.setAutoBase(autoBaseService.getAutoBaseByAutoBaseId(autoBaseId));
        trip.setDispatcher(userService.getUserById(dispatcherId));
        trip.setDriver(userService.getUserById(driverId));

        RequestTripDto requestTripDto = mapper.tripToRequestTripDto(trip);
        assertEquals(trip.getDistanceKm(), requestTripDto.getDistanceKm());
        assertEquals(trip.getTripStatus(), tripEnumConverter.convertToEntityAttribute(requestTripDto.getTripStatus()));
        assertEquals(trip.getFuelLitres(), requestTripDto.getFuelLitres());
        assertEquals(trip.getOrders(), orderService.getOrdersByOrderId(Long.valueOf(requestTripDto.getOrders())));
        assertEquals(trip.getAutoBase(), autoBaseService.getAutoBaseByAutoBaseId(Long.valueOf(requestTripDto.
                getAutoBase())));
        assertEquals(trip.getDispatcher(), userService.getUserById(Long.valueOf(requestTripDto.getDispatcher())));
        assertEquals(trip.getDriver(), userService.getUserById(Long.valueOf(requestTripDto.getDriver())));
    }
}