package homestay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import homestay.entity.Preference;

public interface PreferenceDao extends JpaRepository<Preference, Long> {

}
