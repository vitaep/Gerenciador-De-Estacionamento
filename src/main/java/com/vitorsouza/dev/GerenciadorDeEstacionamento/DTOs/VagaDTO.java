package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VagaDTO {

    private Long id;

    @Min(1)
    private int numero;

    private boolean disponivel;

}
