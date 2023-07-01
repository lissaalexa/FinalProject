package homestay.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Student {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentFirstName;
    private String studentLastName;
    private LocalDate studentDateOfBirth;
	private String studentCountry;
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private Booking booking;
    
    public Long getStudentId() {
    	return studentId;
    }
    
    public void setStudentId(Long id) {
    	this.studentId = id;
    }
    
    public String getStudentFirstName() {
    	return studentFirstName;
    }
    
    public void setStudentFirstName(String firstName) {
    	this.studentFirstName = firstName;
    }
    
    public String getStudentLastName() {
    	return studentLastName;
    }
    
    public void setStudentLastName(String lastName) {
    	this.studentLastName = lastName;
    }
    
	public LocalDate getStudentDateOfBirth() {
		return studentDateOfBirth;
	}
	
	public void setStudentDateOfBirth(LocalDate age) {
    	this.studentDateOfBirth = age;
    }

	public String getStudentCountry() {
		return studentCountry;
	}
	
	public void setStudentCountry(String country) {
    	this.studentCountry = country;
    }
}