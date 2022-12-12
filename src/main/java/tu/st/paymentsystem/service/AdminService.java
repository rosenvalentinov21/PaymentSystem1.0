package tu.st.paymentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.st.paymentsystem.exception.NonExistingEntityException;
import tu.st.paymentsystem.model.Admin;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.model.Student;
import tu.st.paymentsystem.repository.AdminRepository;
import tu.st.paymentsystem.repository.StudentRepository;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public AdminService(final AdminRepository adminRepository,final StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
    }

    public Admin getAdminByPassword(final String password){
        final Admin admin = adminRepository.findAdminByPassword(password);
        if(admin != null)
        {
            return admin;
        }
        else throw new NonExistingEntityException("Could not find admin!");
    }

    public void addGlobalPaymentEvent(final PaymentEvent paymentEvent) {
        final List<Student> allStudents = studentRepository.getAll();

        for (Student s : allStudents) {
            s.getUnpaidEvents().add(paymentEvent);
        }
    }
}
