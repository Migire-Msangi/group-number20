package Group_L.Student.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentResultDto {

    private long id;
    private String firstName;

    private String lastName;

    private String emailId;
    private String programme;

    private String course_code;

    private String course_Marks;

    private String GPA;
}