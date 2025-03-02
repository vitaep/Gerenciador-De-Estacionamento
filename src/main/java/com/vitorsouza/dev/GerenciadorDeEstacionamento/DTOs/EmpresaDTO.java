package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs;


import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpresaDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer vagasMoto;
    private Integer vagasCarro;
    private List<CarModel> carros;


}
