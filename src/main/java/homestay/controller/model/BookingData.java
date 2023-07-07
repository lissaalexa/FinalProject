package homestay.controller.model;

import java.util.Date;

import homestay.entity.Booking;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingData {
	private Long bookingId;		//unique identifier for the booking
	private Long hostId;		//ID of the host family associated with the booking
	private String hostName;	//host family's full name associated with the booking
	private Long studentId;		//ID of the student associated with the booking
	private String studentName;	//student's full name associated with the booking
	private Date startDate;		//start date of the booking
	private Date endDate;		//end date of the booking

    public BookingData(Booking booking) {
        this.bookingId = booking.getBookingId();	//set the booking ID from the provided Booking entity
        this.hostId = booking.getHostFamily().getHostId();		//set the host ID from the associated HostFamily entity
        this.hostName = booking.getHostFamily().getHostFirstName() + " " + booking.getHostFamily().getHostLastName();	//set the host name by concatenating the first name and last name of the host family
        this.studentId = booking.getStudent().getStudentId();	//set the student ID from the associated Student entity
        this.studentName = booking.getStudent().getStudentFirstName() + " " + booking.getStudent().getStudentLastName();	//set the student name by concatenating the first name and last name of the student
        this.startDate = booking.getStartDate();	//set start date from the provided Booking entity
        this.endDate = booking.getEndDate();		//set end date from the provided Booking entity
    }
}
