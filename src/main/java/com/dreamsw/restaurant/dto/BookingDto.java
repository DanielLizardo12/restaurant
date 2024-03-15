package com.dreamsw.restaurant.dto;

import lombok.Builder;
import lombok.Data;

/**
 * BookingDto description.
 *
 * @author Daniel
 * @version 14/03/2024
 */

@Data
@Builder
public class BookingDto {
  private String reservationStartTime;
  private String reservationEndTime;
  private String customerName;
  private int tableSize;
}
