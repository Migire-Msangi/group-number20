package Group_L.Student;


import Group_L.Student.model.Hostel;
import Group_L.Student.repository.HostelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

	@Autowired private HostelRepository hostelRepository;
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Hostel hostel= new Hostel();
		hostel.setCapacity("roomCapacity");
		hostel.setHostelName("hostelName");
		hostel.setRoom("RoomNumber");
		hostel.setStudentFullName("studentName");
		hostel.setPrice("price");
		hostelRepository.save(hostel);

		Hostel hostel1= new Hostel();
		hostel.setCapacity("60_student");
		hostel.setHostelName("MariaNyerere");
		hostel.setRoom("5");
		hostel.setStudentFullName("Twaha_jumanne");
		hostel.setPrice("159500");
		hostelRepository.save(hostel);
	}

	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
