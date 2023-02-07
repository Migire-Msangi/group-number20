package Group_L.Student.service.impl;

import Group_L.Student.dto.HostelDto;
import Group_L.Student.dto.ResponseDto;
import Group_L.Student.dto.StudentDto;
import Group_L.Student.dto.StudentResultDto;
import Group_L.Student.entity.Student;
import Group_L.Student.repository.StudentRepository;
import Group_L.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private RestTemplate restTemplate;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseDto getStudent(Long studentId) {

        ResponseDto responseDto = new ResponseDto();

        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = mapToStudent(student);

        ResponseEntity<HostelDto> responseHostelEntity = restTemplate
                .getForEntity("http://localhost:8081/api/v1/hostels/" + student.getHostelId(),
                        HostelDto.class);
        HostelDto hostelDto = responseHostelEntity.getBody();
        System.out.println(responseHostelEntity.getStatusCode());


        ResponseEntity<StudentResultDto> responseStudentResultEntity = restTemplate
                .getForEntity("http://localhost:8083/api/v1/studentresult/" + student.getStudentResultId(),
                        StudentResultDto.class);
        StudentResultDto studentResultDto = responseStudentResultEntity.getBody();
        System.out.println(responseStudentResultEntity.getStatusCode());



        responseDto.setStudentDto(studentDto);
        responseDto.setHostelDtoDto(hostelDto);
        responseDto.setStudentResultDto(studentResultDto);

        return responseDto;
    }

    private StudentDto mapToStudent(Student student){
        StudentDto doctorDto = new StudentDto();
        doctorDto.setId(student.getId());
        doctorDto.setFirstName(student.getFirstName());
        doctorDto.setLastName(student.getLastName());
        doctorDto.setPhone_number(student.getPhone_number());
        return doctorDto;
    }
}