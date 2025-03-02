package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs;


import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.CarModel;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpresaDTO {

    private Long id;

    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String nome;

    @NotBlank(message = "O campo 'CNPJ' é obrigatório.")
    @Size(min = 22, max = 22, message = "O CNPJ deve ter 14 digitos.")
    private String cnpj;

    @NotBlank(message = "O campo 'Endereço' é obrigatório.")
    private String endereco;

    @NotBlank(message = "O campo 'Telefone' é obrigatório.")
    private String telefone;

    @NotNull(message = "O campo 'Vagas para Motos' é obrigatório.")
    @PositiveOrZero
    private Integer vagasMoto;

    @NotNull(message = "O campo 'Vagas para Carros' é obrigatório.")
    @PositiveOrZero
    private Integer vagasCarro;

    private List<CarModel> carros;


}
