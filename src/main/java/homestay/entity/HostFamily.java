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
	@Column(name = "host_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostId;	//unique identifier for the host family
	
    private String hostFirstName;	//first name of the host family
    private String hostLastName;	//last name of the host family
    private String hostAddress;		//address of the host family
    
    @OneToMany(mappedBy = "hostFamily", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Booking> bookings = new HashSet<>();	//bookings associated with the host family
    
    //getters & setters
    
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
    
    //public Set<Booking> getBookings() {
    //	return bookings;
    //}
    
    //public void setBookings(Set<Booking> bookings) {
    //	this.bookings = bookings;
    //}
}