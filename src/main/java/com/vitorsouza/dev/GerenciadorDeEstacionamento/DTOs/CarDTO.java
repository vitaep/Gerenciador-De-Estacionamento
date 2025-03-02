package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.TipoDeVeiculo;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {

    Long id;
    String marca;
    String modelo;
    String cor;
    String placa;
    TipoDeVeiculo tipo;
    EmpresaModel empresa;

}
