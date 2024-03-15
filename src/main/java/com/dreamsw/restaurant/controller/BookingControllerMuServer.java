package com.dreamsw.restaurant.controller;

import com.dreamsw.restaurant.dto.BookTableDto;
import com.dreamsw.restaurant.service.BookingService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * BookingController description.
 *
 * @author Daniel
 * @version 14/03/2024
 */
@Path("/api/v1/booking")
public class BookingControllerMuServer {

  @Autowired
  BookingService service;

  @POST
  @Path("/CreateBooking")
  @Produces("application/json")
  public void createBooking(@RequestBody BookTableDto scheduleTableDto) {
    service.saveBooking(scheduleTableDto);
  }

}
