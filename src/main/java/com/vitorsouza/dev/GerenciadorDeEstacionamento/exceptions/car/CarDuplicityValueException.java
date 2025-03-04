package com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.car;

public class CarDuplicityValueException extends RuntimeException {
    public CarDuplicityValueException(String message) {
        super(message);
    }

    public CarDuplicityValueException() {
        super("Placa já registrada no sistema, verifique se o veículo já está registrado e tente novamente.");
    }
}
