package Group_L.Student;



import Group_L.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {

	@Autowired private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}


}
