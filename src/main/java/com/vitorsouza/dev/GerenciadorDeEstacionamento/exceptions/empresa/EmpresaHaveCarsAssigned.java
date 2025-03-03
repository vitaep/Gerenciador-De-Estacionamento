package com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa;

public class EmpresaHaveCarsAssigned extends RuntimeException{

    public EmpresaHaveCarsAssigned() {
        super("A empresa tem carros associados ao nome dela, remova os carros e tente novamente.");
    }

    public EmpresaHaveCarsAssigned(String message) {
        super(message);
    }

}
