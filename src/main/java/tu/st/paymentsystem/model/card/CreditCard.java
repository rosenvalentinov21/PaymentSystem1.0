package tu.st.paymentsystem.model.card;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NonNull
    private CreditCardType type;

    @Column(updatable = false, length = 16)
    @NonNull
    private String number;

    @Column(updatable = false, length = 2)
    @NonNull
    private String expMonth;

    @Column(updatable = false, length = 4)
    @NonNull
    private String expYear;
}
