package tu.st.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tu.st.paymentsystem.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getAllByBoardingHouse(int boardinghouse);
    Student findByFacultyId(long facultyId);
}
