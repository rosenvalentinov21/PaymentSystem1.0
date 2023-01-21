package tu.st.paymentsystem.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import tu.st.paymentsystem.DTO.UnpaidPaymentEventDTO;
import tu.st.paymentsystem.exception.NonExistingEntityException;
import tu.st.paymentsystem.model.Admin;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.model.Student;
import tu.st.paymentsystem.repository.AdminRepository;
import tu.st.paymentsystem.repository.StudentRepository;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;

    public List<UnpaidPaymentEventDTO> getAllUnduePayments() {
        var users = studentRepository.getAllByFirstNameNotNull();

        var usersWithOverduePayments = users.stream().filter(u -> u.getUnpaidEvents().stream()
                .filter(this::isPaymentOverdueAndNotPaid).count() > 0).collect(Collectors.toList());

        List<UnpaidPaymentEventDTO> unpaidPaymentsThatAreDue = new ArrayList<>();

        usersWithOverduePayments.forEach(
                s -> s.getUnpaidEvents().forEach(
                        e -> {
                            if (isPaymentOverdueAndNotPaid(e)) {
                                unpaidPaymentsThatAreDue.add(new UnpaidPaymentEventDTO(
                                        s.getFirstName() + " " + s.getLastName(), e.getAmount(),
                                        e.getDue()));
                            }
                        }
                )
        );

        return unpaidPaymentsThatAreDue;
    }

    private boolean isPaymentOverdueAndNotPaid(PaymentEvent e) {
        return !e.isPaid() &&
                e.getDue().toLocalDateTime().toEpochSecond(ZoneOffset.UTC) < LocalDate.now()
                        .toEpochSecond(LocalTime.NOON, ZoneOffset.UTC);
    }

    public Admin getAdminByPassword(final String password) {
        final Admin admin = adminRepository.findAdminByPassword(password);
        if (admin != null) {
            return admin;
        } else {
            throw new NonExistingEntityException("Could not find admin!");
        }
    }

    public void addGlobalPaymentEvent(final PaymentEvent paymentEvent) {
        final List<Student> allStudents =
                studentRepository.getAllByBoardingHouse(paymentEvent.getBoardingHouse());

        for (Student s : allStudents) {
            s.getUnpaidEvents().add(paymentEvent);
        }
    }

    public List<PaymentEvent> getStudentUnpaidEvents(final Long facultyNumber) {
        final Student student = studentRepository.findByFacultyId(facultyNumber);
        return student.getUnpaidEvents();
    }
}
