package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.CarModel;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.vaga.VagaModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstacionamentoDTO {

    private Long id;

    @NotNull
    private CarModel car;

    @NotNull
    private VagaModel vaga;

}
