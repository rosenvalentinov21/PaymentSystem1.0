package tu.st.paymentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tu.st.paymentsystem.model.card.CreditCard;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private int boardingHouse;

    private long facultyId;

    @OneToOne
    @NonNull
    private CreditCard creditCard;

    @OneToMany
    private List<PaymentEvent> unpaidEvents;
}