package homestay.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import homestay.controller.model.BookingData;
import homestay.controller.model.HostFamilyData;
import homestay.controller.model.PreferenceData;
import homestay.controller.model.StudentData;
import homestay.service.HomestayService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/homestay")
@Slf4j
public class HomestayController {

    @Autowired
    private HomestayService homestayService;

    // **BOOKINGS**

    @PostMapping("/booking")
    @ResponseStatus(code = HttpStatus.CREATED)
    //create a booking
    public BookingData createBooking(@RequestBody BookingData bookingData) {
        log.info("Creating booking {}", bookingData);
        return homestayService.createBooking(bookingData);
    }

    @PutMapping("/booking/{bookingId}")
    //update a booking using the booking ID
    public BookingData updateBooking(@PathVariable Long bookingId, @RequestBody BookingData bookingData) {
        bookingData.setBookingId(bookingId);
        log.info("Updating booking {}", bookingData);
        return homestayService.updateBooking(bookingId, bookingData);
    }

    @GetMapping("/booking")
    //retrieve or get all of the bookings
    public List<BookingData> retrieveAllBookings() {
        log.info("Retrieve all bookings");
        return homestayService.retrieveAllBookings();
    }

    @GetMapping("/booking/{bookingId}")
    //retrieve or get all of the bookings by the booking ID
    public BookingData retrieveBookingById(@PathVariable Long bookingId) {
        log.info("Retrieving booking with ID = {} ", bookingId);
        return homestayService.retrieveBookingById(bookingId);
    }

    @DeleteMapping("/booking")
    //deleting all of the bookings
    public void deleteAllBookings() {
        log.info("Deleting all bookings.");
        throw new UnsupportedOperationException("Deleting all bookings is not allowed.");
    }

    @DeleteMapping("/booking/{bookingId}")
    //deleting all of the bookings by the booking ID
    public Map<String, String> deleteBookingById(@PathVariable Long bookingId) {
        log.info("Deleting booking with ID + {} ", bookingId);
        homestayService.deleteBookingById(bookingId);
        return Map.of("message", "Deletion of booking with ID = " + bookingId + " was successful.");
    }

    // **HOST FAMILIES**

    @PostMapping("/hostfamily")
    @ResponseStatus(code = HttpStatus.CREATED)
    //create a host family
    public HostFamilyData createHostFamily(@RequestBody HostFamilyData hostFamilyData) {
        log.info("Creating host family {}", hostFamilyData);
        return homestayService.createHostFamily(hostFamilyData);
    }

    @PutMapping("/hostfamily/{hostId}")
    //update a host family using the host family ID
    public HostFamilyData updateHostFamily(@PathVariable Long hostId, @RequestBody HostFamilyData hostFamilyData) {
        hostFamilyData.setHostId(hostId);
        log.info("Updating host family {}", hostFamilyData);
        return homestayService.updateHost(hostFamilyData);
    }

    @GetMapping("/hostfamily")
    //retrieve or get all of the host families
    public List<HostFamilyData> retrieveAllHosts() {
        log.info("Retrieve all host families.");
        return homestayService.retrieveAllHosts();
    }

    @GetMapping("/hostfamily/{hostId}")
    //retrieve or get all of the host families using the host family ID
    public HostFamilyData retrieveHostFamilyById(@PathVariable Long hostId) {
        log.info("Retrieving host family with ID = {} ", hostId);
        return homestayService.retrieveHostFamilyById(hostId);
    }

    @DeleteMapping("/hostfamily")
    //deleting all of the host families
    public void deleteAllHosts() {
        log.info("Deleting all hosts.");
        throw new UnsupportedOperationException("Deleting all hosts is not allowed.");
    }

    @DeleteMapping("/hostfamily/{hostId}")
    //deleting all of the host families by the host family ID
    public Map<String, String> deleteHostFamilyById(@PathVariable Long hostId) {
        log.info("Deleting host family with ID + {} ", hostId);
        homestayService.deleteHostFamilyById(hostId);
        return Map.of("message", "Deletion of host family with ID = " + hostId + " was successful.");
    }

    // **STUDENTS**

    @PostMapping("/student")
    @ResponseStatus(code = HttpStatus.CREATED)
    //create a student
    public StudentData createStudent(@RequestBody StudentData studentData) {
        log.info("Creating student {}", studentData);
        return homestayService.createStudent(studentData);
    }

    @PutMapping("/student/{studentId}")
    //update a student using the student ID
    public StudentData updateStudent(@PathVariable Long studentId, @RequestBody StudentData studentData) {
        studentData.setStudentId(studentId);
        log.info("Updating student {}", studentData);
        return homestayService.updateStudent(studentData);
    }

    @GetMapping("/student")
    //retrieve or get all of the students
    public List<StudentData> retrieveAllStudents() {
        log.info("Retrieve all students");
        return homestayService.retrieveAllStudents();
    }

    @GetMapping("/student/{studentId}")
    //retrieve or get all of the students using the student ID
    public StudentData retrieveStudentById(@PathVariable Long studentId) {
        log.info("Retrieving student with ID = {} ", studentId);
        return homestayService.retrieveStudentById(studentId);
    }

    @DeleteMapping("/student")
    //deleting all of the students
    public void deleteAllStudents() {
        log.info("Deleting all students.");
        throw new UnsupportedOperationException("Deleting all students is not allowed.");
    }

    @DeleteMapping("/student/{studentId}")
    //deleting all of the students by the student ID
    public Map<String, String> deleteStudentById(@PathVariable Long studentId) {
        log.info("Deleting student with ID + {} ", studentId);
        homestayService.deleteStudentById(studentId);
        return Map.of("message", "Deletion of student with ID = " + studentId + " was successful.");
    }
    
    @PostMapping("/student/{studentId}/preference")
    @ResponseStatus(code = HttpStatus.CREATED)
    //adding a preference to a student
    public StudentData addPreferenceToStudent(@PathVariable Long studentId, @RequestBody PreferenceData preferenceData) {
        log.info("Adding preference {} to student with ID = {}", preferenceData, studentId);
        return homestayService.addPreferenceToStudent(studentId, preferenceData);
    }
    
    @PostMapping("/student/{studentId}/preference/{preferenceId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    //adding an existing preference to a student
    public StudentData addExistingPreferenceToStudent(@PathVariable Long studentId, @PathVariable Long preferenceId) {
        log.info("Adding preference with ID = {} to student with ID = {}", preferenceId, studentId);
        return homestayService.addExistingPreferenceToStudent(studentId, preferenceId);
    }

    @DeleteMapping("/student/{studentId}/preference/{preferenceId}")
    //removing a preference from a student
    public StudentData removePreferenceFromStudent(@PathVariable Long studentId, @PathVariable Long preferenceId) {
        log.info("Removing preference with ID = {} from student with ID = {}", preferenceId, studentId);
        return homestayService.removePreferenceFromStudent(studentId, preferenceId);
    }

    // **PREFERENCES**

    @PostMapping("/preference")
    @ResponseStatus(code = HttpStatus.CREATED)
    //create a preference
    public PreferenceData createPreference(@RequestBody PreferenceData preferenceData) {
        log.info("Creating preference {}", preferenceData);
        return homestayService.createPreference(preferenceData);
    }

    @PutMapping("/preference/{preferenceId}")
    //update a preference using the preference ID
    public PreferenceData updatePreference(@PathVariable Long preferenceId, @RequestBody PreferenceData preferenceData) {
        preferenceData.setPreferenceId(preferenceId);
        log.info("Updating preference {}", preferenceData);
        return homestayService.updatePreference(preferenceData);
    }

    @GetMapping("/preference")
    //retrieve or get all of the preferences
    public List<PreferenceData> retrieveAllPreferences() {
        log.info("Retrieve all preferences");
        return homestayService.retrieveAllPreferences();
    }

    @GetMapping("/preference/{preferenceId}")
    //retrieve or get all of the preferences using the preference ID
    public PreferenceData retrievePreferenceById(@PathVariable Long preferenceId) {
        log.info("Retrieving preference with ID = {} ", preferenceId);
        return homestayService.retrievePreferenceById(preferenceId);
    }

    @DeleteMapping("/preference")
    //deleting all of the preferences
    public void deleteAllPreference() {
        log.info("Deleting all preferences.");
        throw new UnsupportedOperationException("Deleting all preferences is not allowed.");
    }

    @DeleteMapping("/preference/{preferenceId}")
    //deleting all of the preferences by the preference ID
    public Map<String, String> deletePreferenceById(@PathVariable Long preferenceId) {
        log.info("Deleting preference with ID + {} ", preferenceId);
        homestayService.deletePreferenceById(preferenceId);
        return Map.of("message", "Deletion of preference with ID = " + preferenceId + " was successful.");
    }
}