package Group_L.Student.controller;

import Group_L.Student.dto.ResponseDto;
import Group_L.Student.entity.Student;
import Group_L.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/doctors")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getStudent(@PathVariable("id") Long studentId){
        ResponseDto responseDto = studentService.getStudent(studentId);
        return ResponseEntity.ok(responseDto);
    }
}