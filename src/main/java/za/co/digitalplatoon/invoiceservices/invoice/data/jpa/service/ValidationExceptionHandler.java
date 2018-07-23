package za.co.digitalplatoon.invoiceservices.invoice.data.jpa.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> notFoundException(final ConstraintViolationException e) {
        return(new ResponseEntity<String>(e.getConstraintViolations().iterator().next().getMessage(), HttpStatus.BAD_REQUEST));
    }
}
