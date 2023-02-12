package Group_L.Student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private HostelDto hostelDtoDto;
    private StudentResultDto studentResultDto;
    private StudentDto studentDto;

}