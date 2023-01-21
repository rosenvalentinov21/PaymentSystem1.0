package tu.st.paymentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private double amount;

    @Column
    private Timestamp due;

    @Column
    private boolean paid;

    @Column
    private int boardingHouse;

    public PaymentEvent(double amount, Timestamp due) {
        this.amount = amount;
        this.due = due;
    }
}
