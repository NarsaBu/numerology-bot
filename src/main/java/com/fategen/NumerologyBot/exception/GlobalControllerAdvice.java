package com.fategen.NumerologyBot.exception;

import com.fategen.NumerologyBot.dto.ErrorMessageDto;
import com.fategen.NumerologyBot.util.GenerateErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(IllegalDateException.class)
    public ResponseEntity<ErrorMessageDto> illegalDateExceptionHandler(IllegalDateException e) {
        return new ResponseEntity<>(
                GenerateErrorMessage.generateErrorMessageDto(e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IllegalNameException.class)
    public ResponseEntity<ErrorMessageDto> illegalNameExceptionHandler(IllegalNameException e) {
        return new ResponseEntity<>(
                GenerateErrorMessage.generateErrorMessageDto(e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
