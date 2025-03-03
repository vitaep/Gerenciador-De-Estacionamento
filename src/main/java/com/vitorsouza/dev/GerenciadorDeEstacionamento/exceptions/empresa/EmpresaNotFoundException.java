package com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa;

public class EmpresaNotFoundException extends RuntimeException{

    public EmpresaNotFoundException() {
        super("Empresa não encontrada.");
    }

    public EmpresaNotFoundException(String message) {
        super(message);
    }

}
