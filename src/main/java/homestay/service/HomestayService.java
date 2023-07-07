package homestay.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import homestay.controller.model.BookingData;
import homestay.controller.model.HostFamilyData;
import homestay.controller.model.PreferenceData;
import homestay.controller.model.StudentData;
import homestay.dao.BookingDao;
import homestay.dao.HostFamilyDao;
import homestay.dao.PreferenceDao;
import homestay.dao.StudentDao;
import homestay.entity.Booking;
import homestay.entity.HostFamily;
import homestay.entity.Preference;
import homestay.entity.Student;

@Service
public class HomestayService {

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private HostFamilyDao hostFamilyDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private PreferenceDao preferenceDao;

    @Transactional(readOnly = false)
    public BookingData createBooking(BookingData bookingData) {
        Booking booking = new Booking();
        setFieldsInBooking(booking, bookingData);
        return new BookingData(bookingDao.save(booking));
    }

    private void setFieldsInBooking(Booking booking, BookingData bookingData) {
    	//set the fields in the booking entity based on the data being provided
    	booking.setBookingId(bookingData.getBookingId());
        booking.setHostFamily(findHostFamilyById(bookingData.getHostId()));
        booking.setStudent(findStudentById(bookingData.getStudentId()));
        booking.setStartDate(bookingData.getStartDate());
        booking.setEndDate(bookingData.getEndDate());
    }

    @Transactional(readOnly = true)
    public List<BookingData> retrieveAllBookings() {
    	//retrieve all the bookings from the database and map them to BookingData objects
        return bookingDao.findAll().stream()
    //          .map(BookingData::new)
        		.map(booking -> new BookingData(booking))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BookingData retrieveBookingById(Long bookingId) {
    	//retrieve a booking by its ID and map it to the BookingData object
        Booking booking = findBookingById(bookingId);
        return new BookingData(booking);
    }
    
    @Transactional(readOnly = false)
    public void deleteBookingById(Long bookingId) {
    	//delete a booking with the booking ID
        Booking booking = findBookingById(bookingId);
        bookingDao.delete(booking);
    }
    
    @Transactional(readOnly = false)
    public BookingData updateBooking(Long bookingId, BookingData bookingData) {
    	//update the fields of an existing booking based on the provided data
        Booking booking = findBookingById(bookingId);
        setFieldsInBooking(booking, bookingData);
        Booking updatedBooking = bookingDao.save(booking);
        return new BookingData(updatedBooking);
    }

    @Transactional(readOnly = false)
    public HostFamilyData createHostFamily(HostFamilyData hostFamilyData) {
    	HostFamily hostFamily = new HostFamily();
        setFieldsInHostFamily(hostFamily, hostFamilyData);
        return new HostFamilyData(hostFamilyDao.save(hostFamily));
    }

    private void setFieldsInHostFamily(HostFamily hostFamily, HostFamilyData hostFamilyData) {
    	//set the fields in the HostFamily entity based on the data provided
    	hostFamily.setHostId(hostFamilyData.getHostId());
        hostFamily.setHostFirstName(hostFamilyData.getHostFirstName());
        hostFamily.setHostLastName(hostFamilyData.getHostLastName());
        hostFamily.setHostAddress(hostFamilyData.getHostAddress());
    }

    @Transactional(readOnly = true)
    public List<HostFamilyData> retrieveAllHosts() {
    	//retrieve all the host families from the database and map them to the HostFamilyData objects
        return hostFamilyDao.findAll().stream()
                .map(HostFamilyData::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public HostFamilyData retrieveHostFamilyById(Long hostId) {
    	//retrieve a host family by its ID and map it to the HostFamilyData object
        HostFamily hostFamily = findHostFamilyById(hostId);
        return new HostFamilyData(hostFamily);
    }
    
    @Transactional(readOnly = false)
    public HostFamilyData updateHost(HostFamilyData hostFamilyData) {
    	//update the fields of an existing host family based on the provided data
    	HostFamily hostFamily = findHostFamilyById(hostFamilyData.getHostId());
        setFieldsInHostFamily(hostFamily, hostFamilyData);
        return new HostFamilyData(hostFamilyDao.save(hostFamily));
    }

    @Transactional(readOnly = false)
    public void deleteHostFamilyById(Long hostId) {
    	//delete a host family with the given ID from the database
        HostFamily hostFamily = findHostFamilyById(hostId);
        hostFamilyDao.delete(hostFamily);
    }

    @Transactional(readOnly = false)
    public StudentData createStudent(StudentData studentData) {
        Student student = new Student();
        setFieldsInStudent(student, studentData);
        return new StudentData(studentDao.save(student));
    }

    private void setFieldsInStudent(Student student, StudentData studentData) {
    	//set the fields in the Student entity based on the data provided
        student.setStudentFirstName(studentData.getStudentFirstName());
        student.setStudentLastName(studentData.getStudentLastName());
        student.setStudentDateOfBirth(studentData.getStudentDateOfBirth());
        student.setStudentCountry(studentData.getStudentCountry());
    }

    @Transactional(readOnly = false)
    public StudentData updateStudent(StudentData studentData) {
    	//update the fields of an existing student based on the provided data
        Student student = findStudentById(studentData.getStudentId());
        setFieldsInStudent(student, studentData);
        return new StudentData(studentDao.save(student));
    }

    @Transactional(readOnly = true)
    public List<StudentData> retrieveAllStudents() {
    	//retrieve all the students from the database and map them to the StudentData objects
        return studentDao.findAll().stream()
                .map(StudentData::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public StudentData retrieveStudentById(Long studentId) {
    	//retrieve a specific student by its ID and map it to the StudentData object
        Student student = findStudentById(studentId);
        return new StudentData(student);
    }

    @Transactional(readOnly = false)
    public void deleteStudentById(Long studentId) {
    	//delete a student with the given ID from the database
        Student student = findStudentById(studentId);
        studentDao.delete(student);
    }

    @Transactional(readOnly = false)
    public PreferenceData createPreference(PreferenceData preferenceData) {
        Preference preference = new Preference();
        setFieldsInPreference(preference, preferenceData);
        return new PreferenceData(preferenceDao.save(preference));
    }

    private void setFieldsInPreference(Preference preference, PreferenceData preferenceData) {
    	//set the fields in the Preference entity based on the data provided
        preference.setPreferenceName(preferenceData.getPreferenceName());
    }

    @Transactional(readOnly = false)
    public PreferenceData updatePreference(PreferenceData preferenceData) {
    	//update the fields of an existing preference based on the provided data
        Preference preference = findPreferenceById(preferenceData.getPreferenceId());
        setFieldsInPreference(preference, preferenceData);
        return new PreferenceData(preferenceDao.save(preference));
    }

    @Transactional(readOnly = true)
    public List<PreferenceData> retrieveAllPreferences() {
    	//retrieve all the preferences from the database and map them to the PreferenceData objects
        return preferenceDao.findAll().stream()
                .map(PreferenceData::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public PreferenceData retrievePreferenceById(Long preferenceId) {
    	//retrieve a specific preference by its ID and map it to PreferenceData object
        Preference preference = findPreferenceById(preferenceId);
        return new PreferenceData(preference);
    }

    @Transactional(readOnly = false)
    public void deletePreferenceById(Long preferenceId) {
    	//delete a preference with the given ID from the database
        Preference preference = findPreferenceById(preferenceId);
        preferenceDao.delete(preference);
    }

    private Booking findBookingById(Long bookingId) {
    	//method to find a booking by its ID
        return bookingDao.findById(bookingId)
                .orElseThrow(() -> new NoSuchElementException("Booking with ID = " + bookingId + " was not found."));
    }

    private HostFamily findHostFamilyById(Long hostId) {
    	//method to find a host family by its ID
        return hostFamilyDao.findById(hostId)
                .orElseThrow(() -> new NoSuchElementException("Host Family with ID = " + hostId + " was not found."));
    }

    private Student findStudentById(Long studentId) {
    	//method to find a student by its ID
        return studentDao.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with ID = " + studentId + " was not found."));
    }

    private Preference findPreferenceById(Long preferenceId) {
    	//method to find a preference by its ID
        return preferenceDao.findById(preferenceId)
                .orElseThrow(() -> new NoSuchElementException("Preference with ID = " + preferenceId + " was not found."));
    }
}