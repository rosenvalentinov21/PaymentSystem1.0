package tu.st.paymentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class PaymentEventDTO {

    private double amount;

    private Timestamp due;

}
