package tu.st.paymentsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tu.st.paymentsystem.DTO.ErrorDTO;
import tu.st.paymentsystem.exception.NonExistingEntityException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({RuntimeException.class, NonExistingEntityException.class})
    public final ResponseEntity<ErrorDTO> handleAllRuntimeExceptions
            (final RuntimeException ex) {
        final List<String> errorDetails = new ArrayList<>();
        errorDetails.add(ex.getLocalizedMessage());

        final ErrorDTO error = new ErrorDTO(errorDetails, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}