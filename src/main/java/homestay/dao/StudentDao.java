package homestay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import homestay.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
