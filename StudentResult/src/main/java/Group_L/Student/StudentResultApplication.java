package Group_L.Student;


import Group_L.Student.model.StudentResult;

import Group_L.Student.repository.StudentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentResultApplication implements CommandLineRunner {

	@Autowired
	private StudentResultRepository studentResultRepository;
	public static void main(String[] args) {
		SpringApplication.run(StudentResultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StudentResult studentResult= new StudentResult();
		studentResult.setFirstName("peter");
		studentResult.setLastName("john");
		studentResult.setEmailId("peter");
        studentResult.setProgramme("ITS 3");
        studentResult.setCourse_code("CSS 311");
        studentResult.setCourse_Marks("78");
        studentResult.setGPA("3.5");
		studentResultRepository.save(studentResult);

		StudentResult studentResult1= new StudentResult();
		studentResult1.setFirstName("twaha");
		studentResult1.setLastName("jumanne");
		studentResult1.setEmailId("twaha13@gmail.com");
        studentResult1.setProgramme("ITS 3");
        studentResult1.setCourse_code("CSS 311");
        studentResult1.setCourse_Marks("78");
        studentResult1.setGPA("3.5");
		studentResultRepository.save(studentResult1);

	}
}
