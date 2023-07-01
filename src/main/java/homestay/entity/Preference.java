package homestay.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import homestay.entity.Student;

@Entity
@Data
public class Preference {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long preferenceId;
	private String preferenceName;
	
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "preference", cascade = CascadeType.PERSIST)
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
