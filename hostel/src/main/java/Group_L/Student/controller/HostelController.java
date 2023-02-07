package Group_L.Student.controller;





import Group_L.Student.exception.ResourceNotFoundException;
import Group_L.Student.model.Hostel;
import Group_L.Student.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hostels")
public class HostelController {

    @Autowired
    private HostelRepository hostelRepository;

    @GetMapping
    public List<Hostel> getAllstudent(){
        return hostelRepository.findAll();
    }
    // build create student REST API
    @PostMapping
    public  Hostel creatStudent( @RequestBody Hostel hostel){
        return hostelRepository.save(hostel);
    }
    // build get student
    @GetMapping("{id}")
    public ResponseEntity < Hostel>getStudentById(@PathVariable("id")  Long id){
        Hostel hostel= hostelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" Hostel not exist with id :"+ id));
        return ResponseEntity.ok(hostel);
    }
    //build update student REST API
    @PutMapping("{id}")
    public ResponseEntity<Hostel> updateStudent(@PathVariable("id") long id,@RequestBody  Hostel hosteltDetails){
        Hostel updateHostel=hostelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" Hostel not exist with id:" + id));

        updateHostel.setHostelName(hosteltDetails.getHostelName());
        updateHostel.setCapacity(hosteltDetails.getCapacity());
        updateHostel.setRoom(hosteltDetails.getRoom());
        updateHostel.setStudentFullName(hosteltDetails.getStudentFullName());
        updateHostel.setPrice(hosteltDetails.getPrice());


        hostelRepository.save(updateHostel);
        return ResponseEntity.ok(updateHostel);
    }

    //build delete student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id){

        Hostel hostel= hostelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not exist with id:"+ id));

        hostelRepository.delete(hostel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


