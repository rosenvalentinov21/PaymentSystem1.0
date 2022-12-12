package tu.st.paymentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.repository.PaymentEventRepository;

import javax.persistence.PersistenceException;

@Service
public class PaymentEventService {

    private final PaymentEventRepository paymentEventRepository;

    @Autowired
    public PaymentEventService(final PaymentEventRepository paymentEventRepository) {
        this.paymentEventRepository = paymentEventRepository;
    }

    public void create(final PaymentEvent paymentEvent) {
        try {
            paymentEventRepository.save(paymentEvent);
        } catch (PersistenceException e) {
            throw new PersistenceException("There was a problem with persistence!");
        }
    }

}
