package tu.st.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tu.st.paymentsystem.DTO.PaymentDTO;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentOperationsController {

    private StudentService studentService;

    @Autowired
    public StudentOperationsController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity payChosenEvents(@RequestBody final PaymentDTO paymentDTO){
        final List<PaymentEvent> events = paymentDTO.getEvents();
        studentService.removePaid(paymentDTO.getId() ,events);

        return ResponseEntity.ok("");
    }
}
