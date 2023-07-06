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

    // Bookings

    @PostMapping("/booking")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookingData createBooking(@RequestBody BookingData bookingData) {
        log.info("Creating booking {}", bookingData);
        return homestayService.createBooking(bookingData);
    }

    @PutMapping("/booking/{bookingId}")
    public BookingData updateBooking(@PathVariable Long bookingId, @RequestBody BookingData bookingData) {
        bookingData.setBookingId(bookingId);
        log.info("Updating booking {}", bookingData);
        return homestayService.updateBooking(bookingId, bookingData);
    }

    @GetMapping("/booking")
    public List<BookingData> retrieveAllBookings() {
        log.info("Retrieve all bookings");
        return homestayService.retrieveAllBookings();
    }

    @GetMapping("/booking/{bookingId}")
    public BookingData retrieveBookingById(@PathVariable Long bookingId) {
        log.info("Retrieving booking with ID = {} ", bookingId);
        return homestayService.retrieveBookingById(bookingId);
    }

    @DeleteMapping("/booking")
    public void deleteAllBookings() {
        log.info("Deleting all bookings.");
        throw new UnsupportedOperationException("Deleting all bookings is not allowed.");
    }

    @DeleteMapping("/booking/{bookingId}")
    public Map<String, String> deleteBookingById(@PathVariable Long bookingId) {
        log.info("Deleting booking with ID + {} ", bookingId);
        homestayService.deleteBookingById(bookingId);
        return Map.of("message", "Deletion of booking with ID = " + bookingId + " was successful.");
    }

    // Host Families

    @PostMapping("/hostfamily")
    @ResponseStatus(code = HttpStatus.CREATED)
    public HostFamilyData createHostFamily(@RequestBody HostFamilyData hostFamilyData) {
        log.info("Creating host family {}", hostFamilyData);
        return homestayService.createHostFamily(hostFamilyData);
    }

    @PutMapping("/hostfamily/{hostId}")
    public HostFamilyData updateHostFamily(@PathVariable Long hostId, @RequestBody HostFamilyData hostFamilyData) {
        hostFamilyData.setHostId(hostId);
        log.info("Updating host family {}", hostFamilyData);
        return homestayService.updateHost(hostFamilyData);
    }

    @GetMapping("/hostfamily")
    public List<HostFamilyData> retrieveAllHosts() {
        log.info("Retrieve all host families.");
        return homestayService.retrieveAllHosts();
    }

    @GetMapping("/hostfamily/{hostId}")
    public HostFamilyData retrieveHostFamilyById(@PathVariable Long hostId) {
        log.info("Retrieving host family with ID = {} ", hostId);
        return homestayService.retrieveHostFamilyById(hostId);
    }

    @DeleteMapping("/hostfamily")
    public void deleteAllHosts() {
        log.info("Deleting all hosts.");
        throw new UnsupportedOperationException("Deleting all hosts is not allowed.");
    }

    @DeleteMapping("/hostfamily/{hostId}")
    public Map<String, String> deleteHostFamilyById(@PathVariable Long hostId) {
        log.info("Deleting host family with ID + {} ", hostId);
        homestayService.deleteHostFamilyById(hostId);
        return Map.of("message", "Deletion of host family with ID = " + hostId + " was successful.");
    }

    // Students

    @PostMapping("/student")
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentData createStudent(@RequestBody StudentData studentData) {
        log.info("Creating student {}", studentData);
        return homestayService.createStudent(studentData);
    }

    @PutMapping("/student/{studentId}")
    public StudentData updateStudent(@PathVariable Long studentId, @RequestBody StudentData studentData) {
        studentData.setStudentId(studentId);
        log.info("Updating student {}", studentData);
        return homestayService.updateStudent(studentData);
    }

    @GetMapping("/student")
    public List<StudentData> retrieveAllStudents() {
        log.info("Retrieve all students");
        return homestayService.retrieveAllStudents();
    }

    @GetMapping("/student/{studentId}")
    public StudentData retrieveStudentById(@PathVariable Long studentId) {
        log.info("Retrieving student with ID = {} ", studentId);
        return homestayService.retrieveStudentById(studentId);
    }

    @DeleteMapping("/student")
    public void deleteAllStudents() {
        log.info("Deleting all students.");
        throw new UnsupportedOperationException("Deleting all students is not allowed.");
    }

    @DeleteMapping("/student/{studentId}")
    public Map<String, String> deleteStudentById(@PathVariable Long studentId) {
        log.info("Deleting student with ID + {} ", studentId);
        homestayService.deleteStudentById(studentId);
        return Map.of("message", "Deletion of student with ID = " + studentId + " was successful.");
    }

    // Preferences

    @PostMapping("/preference")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PreferenceData createPreference(@RequestBody PreferenceData preferenceData) {
        log.info("Creating preference {}", preferenceData);
        return homestayService.createPreference(preferenceData);
    }

    @PutMapping("/preference/{preferenceId}")
    public PreferenceData updatePreference(@PathVariable Long preferenceId, @RequestBody PreferenceData preferenceData) {
        preferenceData.setPreferenceId(preferenceId);
        log.info("Updating preference {}", preferenceData);
        return homestayService.updatePreference(preferenceData);
    }

    @GetMapping("/preference")
    public List<PreferenceData> retrieveAllPreferences() {
        log.info("Retrieve all preferences");
        return homestayService.retrieveAllPreferences();
    }

    @GetMapping("/preference/{preferenceId}")
    public PreferenceData retrievePreferenceById(@PathVariable Long preferenceId) {
        log.info("Retrieving preference with ID = {} ", preferenceId);
        return homestayService.retrievePreferenceById(preferenceId);
    }

    @DeleteMapping("/preference")
    public void deleteAllPreference() {
        log.info("Deleting all preferences.");
        throw new UnsupportedOperationException("Deleting all preferences is not allowed.");
    }

    @DeleteMapping("/preference/{preferenceId}")
    public Map<String, String> deletePreferenceById(@PathVariable Long preferenceId) {
        log.info("Deleting preference with ID + {} ", preferenceId);
        homestayService.deletePreferenceById(preferenceId);
        return Map.of("message", "Deletion of preference with ID = " + preferenceId + " was successful.");
    }
}