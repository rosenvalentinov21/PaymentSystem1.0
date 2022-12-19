package tu.st.paymentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.model.card.CreditCard;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO {

    private String firstName;

    private String lastName;

    private int boardingHouse;

    private long facultyId;

    private CreditCard creditCard;

    private List<PaymentEvent> unpaidEvents;
}
