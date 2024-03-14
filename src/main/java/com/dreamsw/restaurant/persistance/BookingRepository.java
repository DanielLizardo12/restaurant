package com.dreamsw.restaurant.persistance;

import com.dreamsw.restaurant.entity.Booking;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookingRepository description.
 *
 * @author Daniel
 * @version 14/03/2024
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

  List<Booking> findByDate(Date date);

}
