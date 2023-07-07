package homestay.controller.model;

import homestay.entity.HostFamily;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HostFamilyData {
	private Long hostId;			//unique identifier for the host family
    private String hostFirstName;	//first name of the host family
    private String hostLastName;	//last name of the host family
    private String hostAddress;		//host family's address
    
    public HostFamilyData(HostFamily hostFamily) {
    	hostId = hostFamily.getHostId();				//set the host family's ID from the HostFamily entity
	    hostFirstName = hostFamily.getHostFirstName();	//set the host family's first name from the HostFamily entity
	    hostLastName = hostFamily.getHostLastName();	//set the host family's last name from the HostFamily entity
	    hostAddress = hostFamily.getHostAddress();		//set the host family's address from the HostFamily entity
    }
}
