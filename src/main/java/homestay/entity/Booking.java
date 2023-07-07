package homestay.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
    private Long bookingId;		//unique identifier for the booking
	
	private Date startDate;		//start date of the booking
	private Date endDate;		//end date of the booking
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "host_id", referencedColumnName = "host_id")
	private HostFamily hostFamily = new HostFamily(); 	//host family associated with the booking
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Student student = new Student();	//student associated with the booking
    
    //getters & setters
    
    public Long getBookingId() {
    	return bookingId;
    }
    
    public void setBookingId(Long id) {
    	this.bookingId = id;
    }
    
    public HostFamily getHostFamily() {
    	return hostFamily;
    }
    
    public void setHostFamily(HostFamily hostFamily) {
    	this.hostFamily = hostFamily;
    }

    public Student getStudent() {
    	return this.student;
    }

    public void setStudent(Student student) {
    	this.student = student;
    }
    
    public Date getStartDate() {
    	return startDate;
    }
    
    public void setStartDate(Date startDate) {
    	this.startDate = startDate;
    }

  public Date getEndDate() {
    	return endDate;
    }
    
    public void setEndDate(Date endDate) {
    	this.endDate = endDate;
    }
}