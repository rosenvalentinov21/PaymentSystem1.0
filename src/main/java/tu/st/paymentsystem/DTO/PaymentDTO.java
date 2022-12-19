package tu.st.paymentsystem.DTO;

import lombok.Data;
import tu.st.paymentsystem.model.PaymentEvent;

import java.util.List;

@Data
public class PaymentDTO {

    private Long id;
    private List<PaymentEvent> events;
    private int boardingHouse;
}
