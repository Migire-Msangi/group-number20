package Group_L.Student.repository;


import Group_L.Student.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    //all crud database methods

}



