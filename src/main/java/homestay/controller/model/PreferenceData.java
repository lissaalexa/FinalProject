package homestay.controller.model;

import homestay.entity.Preference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreferenceData {
	private Long preferenceId;
	private String preferenceName;

    public PreferenceData(Preference preference) {
    	preferenceId = preference.getPreferenceId();
    	preferenceName = preference.getPreferenceName();
    }
}