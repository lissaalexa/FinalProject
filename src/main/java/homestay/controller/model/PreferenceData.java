package homestay.controller.model;

import homestay.entity.Preference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreferenceData {
	private Long preferenceId;		//unique identifier for the preference
	private String preferenceName;	//name of the preference

    public PreferenceData(Preference preference) {
    	preferenceId = preference.getPreferenceId();		//set the preference ID from the Preference entity
    	preferenceName = preference.getPreferenceName();	//set the preference name from the Preference entity
    }
}