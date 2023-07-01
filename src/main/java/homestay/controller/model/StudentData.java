package homestay.controller.model;

import java.time.LocalDate;

import homestay.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentData {
	private Long studentId;
    private String studentFirstName;
    private String studentLastName;
    private LocalDate studentDateOfBirth;
	private String studentCountry;
	
    public StudentData(Student student) {
    	studentId = student.getStudentId();
	    studentFirstName = student.getStudentFirstName();
	    studentLastName = student.getStudentLastName();
	    studentDateOfBirth = student.getStudentDateOfBirth();
	    studentCountry = student.getStudentCountry();
    }
}
