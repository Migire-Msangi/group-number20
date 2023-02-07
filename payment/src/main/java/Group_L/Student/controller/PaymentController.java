package Group_L.Student.controller;





import Group_L.Student.exception.ResourceNotFoundException;

import Group_L.Student.model.Payment;
import Group_L.Student.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hostels")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }
    // build create student REST API
    @PostMapping
    public  Payment creatPayment( @RequestBody Payment payment){
        return paymentRepository.save(payment);
    }
    // build get student
    @GetMapping("{id}")
    public ResponseEntity < Payment>getPaymentById(@PathVariable("id")  Long id){
        Payment payment= paymentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" Payment not exist with id :"+ id));
        return ResponseEntity.ok(payment);
    }
    //build update student REST API
    @PutMapping("{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") long id,@RequestBody  Payment payment){
        Payment updatePayment=paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" Payment not exist with id:" + id));

        updatePayment.setPaymentName(payment.getPaymentName());
        updatePayment.setId(payment.getId());
        updatePayment.setDate(payment.getDate());
        updatePayment.setAmount(payment.getAmount());



        paymentRepository.save(updatePayment);
        return ResponseEntity.ok(updatePayment);
    }

    //build delete student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable("id") long id){

        Payment payment= paymentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not exist with id:"+ id));

        paymentRepository.delete(payment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


