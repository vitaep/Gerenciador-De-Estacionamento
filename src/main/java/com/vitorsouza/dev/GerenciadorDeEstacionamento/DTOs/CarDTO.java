package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.TipoDeVeiculo;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {

    Long id;

    @NotBlank(message = "O campo 'marca' é obrigatório.")
    String marca;

    @NotBlank(message = "O campo 'modelo' é obrigatório.")
    String modelo;

    @NotBlank(message = "O campo 'cor' é obrigatório.")
    String cor;

    @NotBlank(message = "O campo 'placa' é obrigatório.")
    @Size(min = 8, max = 8, message = "A placa precisa ter 7 dígitos.")
    String placa;

    @NotNull(message = "O campo 'tipo' é obrigatório.")
    TipoDeVeiculo tipo;

    @NotNull(message = "O campo 'empresa' é obrigatório.")
    EmpresaModel empresa;

}
