package Group_L.Student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone_number;
    private String hostelId;
    private String studentResultId;

}