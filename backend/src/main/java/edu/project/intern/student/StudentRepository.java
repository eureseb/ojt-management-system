package edu.project.intern.student;

import edu.project.intern.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
  Optional<Student> findByAccountInformation(User accountInformation);
}
