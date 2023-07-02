package homestay.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Student {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "student_id") // Map the host_id column
    private Long studentId;
    private String studentFirstName;
    private String studentLastName;
    private LocalDate studentDateOfBirth;
	private String studentCountry;
    
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "preference_student",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "preference_id", referencedColumnName = "preference_id")
    )
    private Set<Preference> preferences = new HashSet<>();
    
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