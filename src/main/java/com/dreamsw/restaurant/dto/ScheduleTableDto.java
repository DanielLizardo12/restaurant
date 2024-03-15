package com.dreamsw.restaurant.dto;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * ScheduleTableDto description.
 *
 * @author Daniel
 * @version 14/03/2024
 */

@Data
public class ScheduleTableDto {
  private String costumerName;
  private int tableSize;
  private LocalDateTime date;

}
