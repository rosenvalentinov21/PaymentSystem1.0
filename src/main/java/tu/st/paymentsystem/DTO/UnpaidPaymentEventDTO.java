package tu.st.paymentsystem.DTO;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnpaidPaymentEventDTO {

    private String userNames;
    private double amount;
    private Timestamp due;

}
