package tu.st.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tu.st.paymentsystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
