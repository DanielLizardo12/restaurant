package com.dreamsw.restaurant.service;

import com.dreamsw.restaurant.dto.BookTableDto;
import com.dreamsw.restaurant.dto.BookingDto;
import com.dreamsw.restaurant.dto.BookingListDto;
import com.dreamsw.restaurant.entity.Booking;
import com.dreamsw.restaurant.persistance.BookingRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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

  public BookingListDto bookingsForTheDay(LocalDateTime startOfDay, LocalDateTime endOfDay) {
    List<Booking> bookingsForTheDay = repository.findByDateBetween(startOfDay, endOfDay);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    List<BookingDto> bookingDtos = new ArrayList<>();
    for (Booking booking : bookingsForTheDay) {
      String startTime = booking.getDate().format(formatter);
      String endTime = booking.getDate().plusHours(2).format(formatter);

      bookingDtos.add(BookingDto.builder()
          .reservationStartTime(startTime)
          .reservationEndTime(endTime)
          .customerName(booking.getCostumerName())
          .tableSize(booking.getTableSize())
          .build());
    }

    DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String formattedDate = startOfDay.format(formatterDay);

    return new BookingListDto(formattedDate, bookingDtos);
  }
}
