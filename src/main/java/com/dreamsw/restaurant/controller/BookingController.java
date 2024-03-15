package com.dreamsw.restaurant.controller;

import com.dreamsw.restaurant.dto.BookTableDto;
import com.dreamsw.restaurant.dto.BookingListDto;
import com.dreamsw.restaurant.entity.Booking;
import com.dreamsw.restaurant.service.BookingService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


  @GetMapping("/books")
  public ResponseEntity<BookingListDto> booksOfTheDay(@RequestParam("date") String date) {

    LocalDate localDate =  LocalDate.parse(date, DateTimeFormatter.ISO_DATE);

    LocalDateTime startOfTheDay = localDate.atStartOfDay();
    LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX);

    return ResponseEntity.ok(service.bookingsForTheDay(startOfTheDay, endOfDay));

  }

}
