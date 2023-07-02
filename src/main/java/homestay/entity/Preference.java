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
    private Long preferenceId;

    private String preferenceName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "preference_student",
        joinColumns = @JoinColumn(name = "preference_id", referencedColumnName = "preference_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    )
    private Set<Student> students = new HashSet<>();
	
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
