package com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.car;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException() {
        super("O carro não foi encontrado.");
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
