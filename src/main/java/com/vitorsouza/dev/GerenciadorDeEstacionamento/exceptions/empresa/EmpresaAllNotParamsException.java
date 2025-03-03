package com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class EmpresaAllNotParamsException extends RuntimeException{

    private HttpStatus httpStatus;
    private Map<String, String> erro;

    public EmpresaAllNotParamsException(HttpStatus httpStatus, Map<String, String> erro) {
        super("Erro de validação dos campos: " + erro.toString());
        this.httpStatus = httpStatus;
        this.erro = erro;
    }

    public EmpresaAllNotParamsException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public EmpresaAllNotParamsException(Map<String, String> erro) {
        this.erro = erro;
    }
}
