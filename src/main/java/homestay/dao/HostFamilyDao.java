package homestay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import homestay.entity.HostFamily;

public interface HostFamilyDao extends JpaRepository<HostFamily, Long> {

}
