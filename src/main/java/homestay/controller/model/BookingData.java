package homestay.controller.model;

import java.util.Date;

import homestay.entity.Booking;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingData {
	private Long bookingId;
	private Long hostId;
	private Long studentId;
	private Date startDate;
	private Date endDate;

    public BookingData(Booking booking) {
    	bookingId = booking.getBookingId();
	    startDate = booking.getStartDate();
	    endDate = booking.getEndDate();
    }
}
