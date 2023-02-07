package Group_L.Student;


import Group_L.Student.model.Enrollment;
import Group_L.Student.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnrollmentApplication implements CommandLineRunner {

	@Autowired
	private EnrollmentRepository enrollmentRepository;
	public static void main(String[] args) {
		SpringApplication.run(EnrollmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Enrollment enrollment= new Enrollment();
		enrollment.setErollment("1324");
		enrollment.setErollment_date("22-11-1998");
		enrollmentRepository.save(enrollment);

	}
}
