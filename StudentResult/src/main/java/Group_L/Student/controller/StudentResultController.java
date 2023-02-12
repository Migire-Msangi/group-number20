package Group_L.Student.controller;





import Group_L.Student.exception.ResourceNotFoundException;
import Group_L.Student.model.StudentResult;
import Group_L.Student.repository.StudentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studentresult")
public class StudentResultController {

    @Autowired
    private StudentResultRepository studentResultRepository;

    @GetMapping
    public List<StudentResult> getAllStudentResult(){
        return studentResultRepository.findAll();
    }
    // build create student REST API
    @PostMapping
    public StudentResult creatStudentResult( @RequestBody StudentResult studentResult){
        return studentResultRepository.save(studentResult);
    }
    // build get student
    @GetMapping("{id}")
    public ResponseEntity <StudentResult>getStudentResultById(@PathVariable  Long id){
        StudentResult studentResult= studentResultRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("StudentResult not exist with id :"+ id));
        return ResponseEntity.ok(studentResult);
    }
    //build update student REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentResult> updateStudentResult(@PathVariable long id,@RequestBody
    StudentResult studentResultDetails){
        StudentResult updateStudentResult=studentResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));

        updateStudentResult.setFirstName(studentResultDetails.getFirstName());
        updateStudentResult.setLastName(studentResultDetails.getLastName());
        updateStudentResult.setEmailId(studentResultDetails.getEmailId());

        studentResultRepository.save(updateStudentResult);
        return ResponseEntity.ok(updateStudentResult);
    }

    //build delete student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){

        StudentResult studentResult= studentResultRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not exist with id:"+ id));

        studentResultRepository.delete(studentResult);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


