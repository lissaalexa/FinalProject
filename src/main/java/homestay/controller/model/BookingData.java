package homestay.controller.model;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingData {
	private Long bookingId;
	private Long host;
	private Long student;
	private Date startDate;
	private Date endDate;

    public BookingData(Long bookingId, Long host, Long student, Date startDate, Date endDate) {
        this.bookingId = bookingId;
        this.host = host;
        this.student = student;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
