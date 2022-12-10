package tu.st.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import tu.st.paymentsystem.model.PaymentEvent;

@Repository
public interface PaymentEventRepository extends JpaRepository<PaymentEvent, Long> {
}
