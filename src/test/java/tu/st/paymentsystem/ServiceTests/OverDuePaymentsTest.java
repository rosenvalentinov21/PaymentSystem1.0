package tu.st.paymentsystem.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import tu.st.paymentsystem.model.PaymentEvent;
import tu.st.paymentsystem.model.Student;
import tu.st.paymentsystem.repository.AdminRepository;
import tu.st.paymentsystem.repository.StudentRepository;
import tu.st.paymentsystem.service.AdminService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class OverDuePaymentsTest {

    @MockBean
    AdminRepository adminRepository;
    @MockBean
    StudentRepository studentRepository;

    @Autowired
    AdminService adminService;

    @Test
    public void testOverduePaymentsCheckTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", "Duhov - overude",
                new ArrayList<PaymentEvent>(
                        List.of(
                                // Overdue payment
                                new PaymentEvent(10, overdueTimeStamp()),
                                new PaymentEvent(20, futureTimestamp())
                        ))
        ));
        students.add(new Student("Ivan", "Duhov2",
                new ArrayList<PaymentEvent>(
                        List.of(
                                new PaymentEvent(20, futureTimestamp())
                        ))
        ));
        when(studentRepository.getAllByFirstNameNotNull()).thenReturn(students);

        var overduePayments = adminService.getAllUnduePayments();
        assertThat(overduePayments.size()).isEqualTo(1);
        assertThat(overduePayments.get(0).getUserNames()).isEqualTo("Ivan Duhov - overude");
    }

    private Timestamp overdueTimeStamp() {
        return new Timestamp(LocalDate.now().toEpochSecond(
                LocalTime.NOON, ZoneOffset.UTC));
    }

    private Timestamp futureTimestamp() {
        Timestamp ts = new Timestamp(LocalDate.now().toEpochSecond(
                LocalTime.NOON, ZoneOffset.UTC));

        Calendar cal = Calendar.getInstance();
        cal.setTime(ts);
        cal.add(Calendar.YEAR, 100);
        ts.setTime(cal.getTime().getTime());

        return ts;
    }

}
