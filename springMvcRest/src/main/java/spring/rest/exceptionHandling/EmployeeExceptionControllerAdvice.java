package spring.rest.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<NoSuchEmployeeExceptionData> employeeNotFoundHandler
            (NoSuchEmployeeException exception){
        NoSuchEmployeeExceptionData data = new NoSuchEmployeeExceptionData(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<NoSuchEmployeeExceptionData> anyExceptionHandler
            (Exception exception){
        NoSuchEmployeeExceptionData data = new NoSuchEmployeeExceptionData(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);

    }
}
