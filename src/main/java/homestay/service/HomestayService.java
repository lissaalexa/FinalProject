package homestay.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import homestay.controller.model.BookingData;
import homestay.dao.BookingDao;
import homestay.entity.Booking;

@Service
public class HomestayService {
	
	@Autowired
	private BookingDao bookingDao;
	//@Autowired
	//private HostFamilyDao hostFamilyDao;
	//@Autowired
	//private StudentDao studentDao;
	//@Autowired
	//private PreferenceDao preferenceDao;

	@Transactional(readOnly = false)
	public BookingData saveBooking(BookingData bookingData) {
		Long bookingId = bookingData.getBookingId();
		Booking booking = findOrCreateBooking (bookingId);
	
		if(Objects.isNull(bookingId)) {
			booking = new Booking();	
		} else {
			booking = findBookingById(bookingId);
		}
		return bookingData;
	}

	private Booking findBookingById(Long bookingId) {
		return bookingDao.findById(bookingId)
				.orElseThrow(() -> new NoSuchElementException("Booking with ID=" + bookingId + " was not found."));
	}
}
