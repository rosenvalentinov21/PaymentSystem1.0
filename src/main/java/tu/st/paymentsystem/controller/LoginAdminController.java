package tu.st.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tu.st.paymentsystem.DTO.LoginDTO;
import tu.st.paymentsystem.DTO.PaymentEventDTO;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.service.AdminService;

@RestController
@RequestMapping("/login")
public class LoginAdminController {

    private final AdminService adminService;

    @Autowired
    public LoginAdminController(final AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody final LoginDTO loginDTO) {
        adminService.getAdminByPassword(loginDTO.getPassword());
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody final PaymentEventDTO paymentEventDTO) {
        final PaymentEvent paymentEvent = new PaymentEvent(paymentEventDTO.getAmount(), paymentEventDTO.getDue());
        adminService.addGlobalPaymentEvent(paymentEvent);
        return ResponseEntity.ok("");
    }

}
