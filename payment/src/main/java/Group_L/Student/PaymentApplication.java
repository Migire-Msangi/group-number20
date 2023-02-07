package Group_L.Student;



import Group_L.Student.model.Payment;
import Group_L.Student.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {

	@Autowired private PaymentRepository paymentRepository;
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Payment payment= new Payment();
		payment.setAmount("59500");
		payment.setDate("22-11-1998");
		payment.setPaymentName("Ada");


	}
}
