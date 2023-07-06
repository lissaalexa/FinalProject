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
	private String hostName;
	private Long studentId;
	private String studentName;
	private Date startDate;
	private Date endDate;

    public BookingData(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.hostId = booking.getHostFamily().getHostId();
        this.hostName = booking.getHostFamily().getHostFirstName() + " " + booking.getHostFamily().getHostLastName();
        this.studentId = booking.getStudent().getStudentId();
        this.studentName = booking.getStudent().getStudentFirstName() + " " + booking.getStudent().getStudentLastName();
        this.startDate = booking.getStartDate();
        this.endDate = booking.getEndDate();
    }
}
