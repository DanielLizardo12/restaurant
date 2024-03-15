package com.dreamsw.restaurant;
import com.dreamsw.restaurant.controller.BookingControllerMuServer;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.rest.RestHandlerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		BookingControllerMuServer bookingController = new BookingControllerMuServer();

		MuServer server = MuServerBuilder.httpServer()
				.addHandler(RestHandlerBuilder.restHandler(bookingController))
				.start();

		System.out.println("API example: " + server.uri());
		SpringApplication.run(RestaurantApplication.class, args);
	}
}
