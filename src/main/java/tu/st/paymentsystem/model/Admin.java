package tu.st.paymentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "boarding_house")
    private int boardingHouse;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

//Insert into admin (id,first_name, last_name, boarding_house,password, phone_number) values (1,'rosen', 'ivanov', 54,1234321, '0884010590');
}
