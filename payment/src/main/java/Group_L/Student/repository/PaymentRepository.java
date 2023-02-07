package Group_L.Student.repository;


import Group_L.Student.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PaymentRepository extends JpaRepository<Payment,Long> {
    //all crud database methods

}



