package homestay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homestay.controller.model.BookingData;
import homestay.service.HomestayService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/homestay")
@Slf4j
public class HomestayController {
	@Autowired
	 private HomestayService homestayService;
	
	@PostMapping("/booking")
	public BookingData saveBooking( 
		@RequestBody BookingData bookingData) {
		log.info("Creating booking {}", bookingData);
		return homestayService.saveBooking(bookingData);
	}
}
