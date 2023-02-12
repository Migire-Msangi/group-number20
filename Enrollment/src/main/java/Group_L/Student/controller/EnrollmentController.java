package Group_L.Student.controller;





import Group_L.Student.exception.ResourceNotFoundException;
import Group_L.Student.model.Enrollment;
import Group_L.Student.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @GetMapping
    public List<Enrollment> getAllEnrollmentResult(){
        return enrollmentRepository.findAll();
    }
    // build create Enrollment REST API
    @PostMapping
    public Enrollment creatEnrollment( @RequestBody Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }
    // build get Enrollment
    @GetMapping("{id}")
    public ResponseEntity <Enrollment>getEnrollmentById(@PathVariable  Long id){
        Enrollment enrollment= enrollmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Enrollment not exist with id :"+ id));
        return ResponseEntity.ok(enrollment);
    }
    //build update Enrollment REST API
    @PutMapping("{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable long id, @RequestBody
    Enrollment enrollmentDetails){
        Enrollment updateEnrollment=enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not exist with id:" + id));

        updateEnrollment.setId(enrollmentDetails.getId());
        updateEnrollment.setErollment_date(enrollmentDetails.getErollment_date());
        updateEnrollment.setErollment(enrollmentDetails.getErollment());

        enrollmentRepository.save(updateEnrollment);
        return ResponseEntity.ok(updateEnrollment);
    }

    //build delete student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){

        Enrollment enrollment= enrollmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Enrollment not exist with id:"+ id));

        enrollmentRepository.delete(enrollment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


