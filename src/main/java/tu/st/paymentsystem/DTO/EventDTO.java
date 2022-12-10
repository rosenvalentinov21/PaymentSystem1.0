package tu.st.paymentsystem.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class EventDTO {
    private Long id;

    private double amount;

    private Timestamp due;
}
