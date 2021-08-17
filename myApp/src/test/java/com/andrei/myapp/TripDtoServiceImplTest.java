package com.andrei.myapp;

import com.andrei.myapp.dto.RequestTripDto;
import com.andrei.myapp.dto.TripDto;
import com.andrei.myapp.model.dao.TripDao;
import com.andrei.myapp.model.entity.Trip;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.service.interfaces.TripDtoService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripDtoServiceImplTest {
    @Autowired
    TripDtoService tripDtoService;
    @MockBean
    TripDao dao;
    private final Long id = 1L;
    private final Long tripId = 3L;
    private final Long driverId = 2L;
    String login = "Vasia";
    User driver = new User();
    @Before
    public void setUp() {
        Trip trip = new Trip();
        Trip secondTrip = new Trip();
        driver.setUserId(driverId);
        driver.setLogin(login);
        trip.setTripId(id);
        trip.setDriver(driver);
        secondTrip.setTripId(tripId);
        secondTrip.setDriver(driver);
        List<Trip> trips = new ArrayList<>();
        trips.add(trip);
        trips.add(secondTrip);
        Mockito.when(dao.getTripByTripId(id)).thenReturn(trip);
        Mockito.when(dao.getTripsByDriver(driver)).thenReturn(trips);
    }

    @org.junit.Test
    public void getTripByTripIdTest() {
        TripDto tripDto = tripDtoService.getTripByTripId(id);
        Assertions.assertNotEquals(null, tripDto);
    }
    @org.junit.Test
    public void getTripsByDriverTest(){
        List<TripDto>tripDtos=tripDtoService.getTripsByDriver(driver);
        Assertions.assertEquals(2,tripDtos.size());

}
}
