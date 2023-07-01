package homestay.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import homestay.entity.Student;
import homestay.entity.HostFamily;

@Entity
@Data
public class Booking {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long bookingId;
	private Long hostId;
	private Long studentId;
	private Date startDate;
	private Date endDate;
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "booking_host_family",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "host_family_id"))
    private Set<HostFamily> hostFamilies = new HashSet<>();
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "homestay", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students = new HashSet<>();
    
    public Long getBookingId() {
    	return bookingId;
    }
    
    public void setBookingId(Long id) {
    	this.bookingId = id;
    }
    
    public Long getHostId() {
    	return hostId;
    }
    
    public void setHostId(Long hostId) {
    	this.hostId = hostId;
    }

    public Long getStudentId() {
    	return studentId;
    }

    public void setStudentId(Long studentId) {
    	this.studentId = studentId;
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

    public Set<Student> getStudents() {
    	return students;
    }
    
    public Set<HostFamily> getHostFamilies() {
    	return hostFamilies;
    } 
}