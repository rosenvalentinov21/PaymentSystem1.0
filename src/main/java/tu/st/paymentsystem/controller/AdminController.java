package tu.st.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tu.st.paymentsystem.DTO.PaymentEventDTO;
import tu.st.paymentsystem.DTO.StudentDTO;
import tu.st.paymentsystem.DTO.UnpaidPaymentEventDTO;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.model.Student;
import tu.st.paymentsystem.service.AdminService;
import tu.st.paymentsystem.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final StudentService studentService;

    @Autowired
    public AdminController(final AdminService adminService, final StudentService studentService) {
        this.adminService = adminService;
        this.studentService = studentService;
    }


    @PostMapping("new-event")
    public ResponseEntity createPaymentEvent(@RequestBody final PaymentEventDTO paymentEventDTO) {
        final PaymentEvent paymentEvent =
                new PaymentEvent(paymentEventDTO.getAmount(), paymentEventDTO.getDue());

        adminService.addGlobalPaymentEvent(paymentEvent);
        return ResponseEntity.ok("");
    }

    @PostMapping("add-student")
    public ResponseEntity addStudent(@RequestBody final StudentDTO studentDTO) {
        final Student student = new Student(studentDTO.getFirstName(), studentDTO.getLastName(),
                studentDTO.getBoardingHouse(), studentDTO.getFacultyId(),
                studentDTO.getCreditCard(), studentDTO.getUnpaidEvents());

        studentService.addStudent(student);
        return ResponseEntity.ok("");
    }

    @GetMapping("check-student/{facultyId}")
    public List<PaymentEventDTO> checkStudent(@PathVariable final Long facultyId) {
        final List<PaymentEvent> events = adminService.getStudentUnpaidEvents(facultyId);
        final List<PaymentEventDTO> eventDTOs = new ArrayList<>();
        for (PaymentEvent event : events) {
            eventDTOs.add(new PaymentEventDTO(event.getAmount(), event.getDue()));
        }
        return eventDTOs;
    }

    @GetMapping("getOverdueUnpaidEvents")
    public ResponseEntity<List<UnpaidPaymentEventDTO>> getDuePayments() {
        return new ResponseEntity<>(adminService.getAllUnduePayments(), HttpStatus.ACCEPTED);
    }
}
