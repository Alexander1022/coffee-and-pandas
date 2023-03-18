package com.fmi.entertizer.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleInvalidEmailException(InvalidEmailException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ResultMsgStatus resultMsgStatus = new ResultMsgStatus(e.getMessage(), badRequest);

        return new ResponseEntity<>(resultMsgStatus, badRequest);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException e){
        HttpStatus notAcceptable = HttpStatus.NOT_ACCEPTABLE;
        ResultMsgStatus resultMsgStatus = new ResultMsgStatus(e.getMessage(), notAcceptable);

        return new ResponseEntity<>(resultMsgStatus, notAcceptable);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ResultMsgStatus resultMsgStatus = new ResultMsgStatus(e.getMessage(), notFound);

        return new ResponseEntity<>(resultMsgStatus, notFound);
    }

}
