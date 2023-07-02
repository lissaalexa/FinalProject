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
	@Column(name = "booking_id") // Map the host_id column
    private Long bookingId;
	
	private Date startDate;
	private Date endDate;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "host_family_id", referencedColumnName = "host_id")
    private HostFamily hostFamily = new HostFamily();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student = new Student();
    
    public Long getBookingId() {
    	return bookingId;
    }
    
    public void setBookingId(Long id) {
    	this.bookingId = id;
    }
    
    public HostFamily getHost() {
    	return hostFamily;
    }
    
    public void setHost(HostFamily hostFamily) {
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

    public HostFamily getHostFamily() {
    	return hostFamily;
    } 
}