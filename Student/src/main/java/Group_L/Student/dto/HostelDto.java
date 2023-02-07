package Group_L.Student.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HostelDto {
    private long id;
    private String hostelName;
    private String studentFullName;
    private String room;
    private String capacity;
    private String price;
}