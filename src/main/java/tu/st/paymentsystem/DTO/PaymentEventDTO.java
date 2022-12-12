package tu.st.paymentsystem.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PaymentEventDTO {

    private double amount;

    private Timestamp due;
}
