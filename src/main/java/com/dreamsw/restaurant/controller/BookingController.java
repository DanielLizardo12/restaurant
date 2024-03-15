package com.dreamsw.restaurant.controller;

import com.dreamsw.restaurant.dto.BookTableDto;
import com.dreamsw.restaurant.entity.Booking;
import com.dreamsw.restaurant.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookingController description.
 *
 * @author Daniel
 * @version 14/03/2024
 */
@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

  private final BookingService service;

  @PostMapping("/book")
  public ResponseEntity<String> bookTable(@RequestBody BookTableDto dto) {
    Booking booking = service.saveBooking(dto);
    return ResponseEntity.ok(booking.toString());
  }

}
