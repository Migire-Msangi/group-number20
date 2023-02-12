package Group_L.Student.service;

import Group_L.Student.dto.ResponseDto;
import Group_L.Student.entity.Student;


public interface StudentService {
    Student saveStudent(Student student);

    ResponseDto getStudent(Long studentId);


}
