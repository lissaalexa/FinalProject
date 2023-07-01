package homestay.controller.model;

import homestay.entity.HostFamily;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HostFamilyData {
	private Long hostId;
    private String hostFirstName;
    private String hostLastName;
    private String hostAddress;
    
    public HostFamilyData(HostFamily hostFamily) {
    	hostId = hostFamily.getHostId();
	    hostFirstName = hostFamily.getHostFirstName();
	    hostLastName = hostFamily.getHostLastName();
	    hostAddress = hostFamily.getHostAddress();
    }
}
