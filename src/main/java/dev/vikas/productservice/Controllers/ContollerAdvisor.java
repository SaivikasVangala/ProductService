package dev.vikas.productservice.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContollerAdvisor {
     @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
     @ExceptionHandler(NullPointerException.class)
    public void handleNUllException(Exception ex){
         System.out.println(ex.getMessage());
    }
}
