package tu.st.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tu.st.paymentsystem.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByPassword(String password);
}
