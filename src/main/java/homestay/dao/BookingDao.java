package homestay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import homestay.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Long> {

}