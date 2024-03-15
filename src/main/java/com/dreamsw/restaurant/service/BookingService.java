package com.dreamsw.restaurant.service;

import com.dreamsw.restaurant.dto.BookTableDto;
import com.dreamsw.restaurant.entity.Booking;
import com.dreamsw.restaurant.persistance.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * BookingService description.
 *
 * @author Daniel
 * @version 14/03/2024
 */

@Service
@RequiredArgsConstructor
public class BookingService {

  private final BookingRepository repository;

  public Booking saveBooking(BookTableDto scheduleTableDto) {

    Booking booking = Booking.builder()
        .costumerName(scheduleTableDto.getCostumerName())
        .tableSize(scheduleTableDto.getTableSize())
        .date(scheduleTableDto.getDate())
        .build();

    return repository.save(booking);
  }

}
