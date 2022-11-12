package tu.st.paymentsystem.model.card;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "credit_card")
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "cc_type")
    @NonNull
    private CreditCardType type;

    @Column(name = "cc_number", updatable = false, length = 16)
    @NonNull
    private String number;

    @Column(name = "cc_exp_month", updatable = false, length = 2)
    @NonNull
    private String expMonth;

    @Column(name = "cc_exp_year", updatable = false, length = 4)
    @NonNull
    private String expYear;
}
