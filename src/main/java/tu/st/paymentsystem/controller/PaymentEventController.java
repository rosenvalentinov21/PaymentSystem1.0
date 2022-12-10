package tu.st.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tu.st.paymentsystem.DTO.EventDTO;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.service.PaymentEventService;

@RestController
@RequestMapping("/event")
public class PaymentEventController {

    @Autowired
    private PaymentEventService paymentEventService;

    @PostMapping
    public ResponseEntity createEvent(@RequestBody final EventDTO eventDTO) {
        final PaymentEvent paymentEvent = new PaymentEvent(eventDTO.getAmount(), eventDTO.getDue());
        paymentEventService.save(paymentEvent);
        return ResponseEntity.ok("");
    }
}
