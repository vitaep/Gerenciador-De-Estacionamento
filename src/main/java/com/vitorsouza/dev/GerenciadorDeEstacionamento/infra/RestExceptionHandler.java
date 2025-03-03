package com.vitorsouza.dev.GerenciadorDeEstacionamento.infra;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaAllNotParamsException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaDuplicityValuesException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaHaveCarsAssigned;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmpresaNotFoundException.class)
    private ResponseEntity<RestErrorMessage> empresaNotFoundException(EmpresaNotFoundException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(threatResponse);
    }

    @ExceptionHandler(EmpresaHaveCarsAssigned.class)
    private ResponseEntity<RestErrorMessage> empresaHaveCarsAssignedException(EmpresaHaveCarsAssigned exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(threatResponse);
    }

    @ExceptionHandler(EmpresaDuplicityValuesException.class)
    private ResponseEntity<RestErrorMessage> duplicityValuesException(EmpresaDuplicityValuesException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(threatResponse);
    }

    @ExceptionHandler(EmpresaAllNotParamsException.class)
    private ResponseEntity<RestErrorMessage> allNotParamsException(EmpresaAllNotParamsException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.UNAUTHORIZED, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(threatResponse);
        }

}
