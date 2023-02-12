package Group_L.Student.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ResponseStatus(value = NOT_FOUND)
public class  ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){

        super(message);
    }
}
