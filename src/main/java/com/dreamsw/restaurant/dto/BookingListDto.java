package com.dreamsw.restaurant.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * BookingsDto description.
 *
 * @author Daniel
 * @version 14/03/2024
 */

@Data
@AllArgsConstructor
public class BookingListDto {

  private String date;
  private List<BookingDto> bookingList;
}
