package com.dreamsw.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

/**
 * Booking description.
 *
 * @author Daniel
 * @version 14/03/2024
 */

@Entity
@Data
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String costumerName;
  private int tableSize;
  private Date date;
  private String time;



}
