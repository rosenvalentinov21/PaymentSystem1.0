package tu.st.paymentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tu.st.paymentsystem.model.card.CreditCard;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "faculty_id")
    private long facultyId;

    @Column(name = "boarding_house")
    private int boardingHouse;

    @OneToOne
    @Column(name = "credit_card")
    @NonNull
    private CreditCard creditCard;
}
