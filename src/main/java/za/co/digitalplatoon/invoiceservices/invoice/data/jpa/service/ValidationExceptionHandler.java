package za.co.digitalplatoon.invoiceservices.invoice.data.jpa.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.co.digitalplatoon.invoiceservices.invoice.data.jpa.model.ResponseError;

import javax.validation.ConstraintViolationException;
import javax.xml.ws.Response;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseError> notFoundException(final ConstraintViolationException e) {
        ResponseError error=    new ResponseError();
        error.setErrorMessage(e.getConstraintViolations().iterator().next().getMessage());
        return(new ResponseEntity<ResponseError>(error, HttpStatus.BAD_REQUEST));
    }
}
