package homestay.entity;

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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Preference {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_id")
    private Long preferenceId;		//unique identifier for the preference

    private String preferenceName;	//name of preference

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL) //relationship with Student entities using a many-to-many association
    @JoinTable(
        name = "preference_student",		//name of the join table in the database
        joinColumns = @JoinColumn(name = "preference_id", referencedColumnName = "preference_id"),	//column mapping for preference_id
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id")	//column mapping for student_id
    )
    private Set<Student> students = new HashSet<>();	//set of students associated with the preference
	
    //getters & setters
    
	public Long getPreferenceId() {
    	return preferenceId;
    }
    
    public void setPreferenceId(Long id) {
    	this.preferenceId = id;
    }
    
    public String getPreferenceName() {
    	return preferenceName;
    }
    
    public void setPreferenceName(String preferenceName) {
    	this.preferenceName = preferenceName;
    }
}
