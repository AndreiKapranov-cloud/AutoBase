package com.andrei.myapp;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.mapper.TripToRequestTripDtoMapperImpl;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.service.interfaces.AutoBaseService;
import com.andrei.myapp.service.interfaces.OrderService;
import com.andrei.myapp.service.interfaces.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripToRequestDtoMapperImplTest {

    @Mock
    private UserService userService;
    @Mock
    private OrderService orderService;
    @Mock
    private AutoBaseService autoBaseService;

    private TripToRequestTripDtoMapperImpl mapper;

    @Before
    public void init() {
        mapper = new TripToRequestTripDtoMapperImpl(autoBaseService, orderService, userService);
    }

    @org.junit.Test
    public void givenTripToRequestTripDto_whenMaps_thenCorrect() {
        Trip trip = new Trip();
        trip.setDistanceKm(25);
        trip.setFinished(false);
        trip.setOrders(orderService.getOrdersByOrderId(1L));
        trip.setAutoBase(autoBaseService.getAutoBaseByAutoBaseId(1L));
        trip.setDispatcher(userService.getUserById(8L));
        trip.setDriver(userService.getUserById(3L));
       System.out.println(trip.getDriver());
        RequestTripDto requestTripDto = mapper.tripToRequestTripDto(trip);

        System.out.println(requestTripDto.getAutoBase());

        assertEquals(trip.getDistanceKm(), requestTripDto.getDistanceKm());
        assertEquals(trip.getFinished(), requestTripDto.getFinished());
        assertEquals(trip.getOrders(), orderService.getOrdersByOrderId(Long.valueOf(requestTripDto.getOrders())));
        assertEquals(trip.getAutoBase(), autoBaseService.getAutoBaseByAutoBaseId(Long.valueOf(requestTripDto.getAutoBase())));
        assertEquals(trip.getDispatcher(), userService.getUserById(Long.valueOf(requestTripDto.getDispatcher())));
        assertEquals(trip.getDriver(), userService.getUserById(Long.valueOf(requestTripDto.getDriver())));

    }
  /*  @org.junit.Test
    public void givenRequestTripDtoToTrip_whenMaps_thenCorrect(){
        RequestTripDto requestTripDto=new RequestTripDto();
        requestTripDto.setDistanceKm(33);
        requestTripDto.setFinished(false);
        requestTripDto.setOrders("1");
        requestTripDto.setAutoBase("1");
        requestTripDto.setDispatcher("3");

    }*/
}
