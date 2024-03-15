package com.dreamsw.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Booking description.
 *
 * @author Daniel
 * @version 14/03/2024
 */

@Entity
@Data
@Builder
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String costumerName;
  private int tableSize;
  private LocalDateTime date;

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

  @Override
  public String toString() {
    return String.format("Booked table for %s, at %s Table for %s people",
        costumerName, date.format(formatter), tableSize);
  }

}
