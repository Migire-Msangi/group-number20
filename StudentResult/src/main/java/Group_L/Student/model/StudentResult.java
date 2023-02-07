package Group_L.Student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studentResult")
public class StudentResult {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_Id")
    private String emailId;
    @Column(name= "programme")
    private String programme;

    @Column(name="course_code")
    private String course_code;

    @Column(name="course_Marks")
    private String course_Marks;

    @Column(name="GPA")
    private String GPA;

}




