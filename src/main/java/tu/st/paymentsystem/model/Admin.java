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
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private int boardingHouse;

    private String password;

    private String phoneNumber;

//Insert into admin (id,first_name, last_name, boarding_house,password, phone_number) values (1,'rosen', 'ivanov', 54,1234321, '0884010590');
}
