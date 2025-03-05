package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.mappers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.VagaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.vaga.VagaModel;
import org.springframework.stereotype.Component;

@Component
public class VagaMapper {

    public VagaModel map(VagaDTO vagaDTO){

        VagaModel vagaModel = new VagaModel();

        vagaModel.setId(vagaDTO.getId());
        vagaModel.setNumero(vagaDTO.getNumero());
        vagaModel.setDisponivel(vagaDTO.isDisponivel());

        return vagaModel;
    }

    public VagaDTO map(VagaModel vagaModel){

        VagaDTO vagaDTO = new VagaDTO();

        vagaDTO.setId(vagaModel.getId());
        vagaDTO.setNumero(vagaModel.getNumero());
        vagaDTO.setDisponivel(vagaModel.isDisponivel());

        return vagaDTO;

    }

}
