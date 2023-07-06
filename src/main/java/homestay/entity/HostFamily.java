package homestay.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class HostFamily {
	@Id
	@Column(name = "host_id") // Map the host_id column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostId;
    private String hostFirstName;
    private String hostLastName;
    private String hostAddress;
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "hostFamily", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();
    
    public Long getHostId() {
    	return hostId;
    }
    
    public void setHostId(Long id) {
    	this.hostId = id;
    }
    
    public String getHostFirstName() {
    	return hostFirstName;
    }
    
    public void setHostFirstName(String firstName) {
    	this.hostFirstName = firstName;
    }
    
    public String getHostLastName() {
    	return hostLastName;
    }
    
    public void setHostLastName(String lastName) {
    	this.hostLastName = lastName;
    }
    
    public String getHostAddress() {
    	return hostAddress;
    }
    
    public void setHostAddress(String address) {
    	this.hostAddress = address;
    }
}