package tu.st.paymentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.st.paymentsystem.exception.NonExistingEntityException;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.model.Student;
import tu.st.paymentsystem.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public boolean addGlobalPaymentEvent(final PaymentEvent paymentEvent) {
        final List<Student> allStudents = studentRepository.getAll();

        for (Student s : allStudents) {
            s.getUnpaidEvents().add(paymentEvent);
        }
        return true;
    }

    public void removePaid(final Long id, final List<PaymentEvent> paidEvents) {
        final Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(""));

        final List<PaymentEvent> allEvents = student.getUnpaidEvents();
        for (final PaymentEvent e1 : allEvents) {
            for (final PaymentEvent e2 : paidEvents) {
                if (e1.getId().equals(e2.getId())) {
                    allEvents.remove(e1);
                }
            }
        }

        student.setUnpaidEvents(allEvents);
    }
}
