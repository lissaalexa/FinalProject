package homestay.controller.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import homestay.entity.Preference;
import homestay.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentData {
	private Long studentId;			//unique identifier for the student
    private String studentFirstName;	//first name of the student
    private String studentLastName;		//last name of the student
    private LocalDate studentDateOfBirth;	//date of birth of the student
	private String studentCountry;		//the country the student is from
	private Set<PreferenceData> preferences = new HashSet<>();	//set of preferences associated with the student
	
    public StudentData(Student student) {
    	studentId = student.getStudentId();		//set the student ID from the provided Student entity
	    studentFirstName = student.getStudentFirstName();	//set the student's first name from the provided Student entity
	    studentLastName = student.getStudentLastName();		//set the student's last name from the provided Student entity
	    studentDateOfBirth = student.getStudentDateOfBirth();	//set the student's date of birth from the provided Student entity
	    studentCountry = student.getStudentCountry();		//set the student's country from the provided Student entity
	    
	    for (Preference preference : student.getPreferences()) {	//set the preferences
			preferences.add(new PreferenceData(preference) );
		}
    }
}
