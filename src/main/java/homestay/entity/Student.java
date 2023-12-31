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
	@Column(name = "student_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long studentId;				//unique identifier for the student
    private String studentFirstName;	//first name of the student
    private String studentLastName;		//last name of the student
    private LocalDate studentDateOfBirth;	//date of birth of the student
	private String studentCountry;		//the country the student is from
    
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();	//set of bookings associated with the student

	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)	//relationship with Preference entities using a many-to-many association
    @JoinTable(
        name = "preference_student",			//name of the join table in the database
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),	//column mapping for student_id
        inverseJoinColumns = @JoinColumn(name = "preference_id", referencedColumnName = "preference_id")	//column mapping for preference_id
    )
    private Set<Preference> preferences = new HashSet<>();	//set of preferences associated with the student
    
	//getters & setters
	
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