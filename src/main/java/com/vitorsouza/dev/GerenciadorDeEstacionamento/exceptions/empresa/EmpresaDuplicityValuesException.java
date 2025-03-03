package com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa;

public class EmpresaDuplicityValuesException extends RuntimeException{

    public EmpresaDuplicityValuesException(String message) {
        super(message);
    }

    public EmpresaDuplicityValuesException() {
        super("Essa empresa já está registrada no sistema, verifique se os campos 'nome' e 'CNPJ' já existem e tente novamente.");
    }

}
