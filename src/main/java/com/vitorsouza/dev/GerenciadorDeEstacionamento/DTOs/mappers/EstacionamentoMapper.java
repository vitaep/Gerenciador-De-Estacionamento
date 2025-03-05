package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.mappers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EstacionamentoDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.estacionamento.EstacionamentoModel;
import org.springframework.stereotype.Component;

@Component
public class EstacionamentoMapper {

    public EstacionamentoModel map(EstacionamentoDTO estacionamentoDTO){

        EstacionamentoModel estacionamentoModel = new EstacionamentoModel();

        estacionamentoModel.setId(estacionamentoDTO.getId());
        estacionamentoModel.setCar(estacionamentoDTO.getCar());
        estacionamentoModel.setVaga(estacionamentoDTO.getVaga());

        return estacionamentoModel;

    }

    public EstacionamentoDTO estacionalmentoDTO(EstacionamentoModel estacionamentoModel){

        EstacionamentoDTO estacionamentoDTO = new EstacionamentoDTO();

        estacionamentoDTO.setId(estacionamentoModel.getId());
        estacionamentoDTO.setCar(estacionamentoModel.getCar());
        estacionamentoDTO.setVaga(estacionamentoModel.getVaga());

        return estacionamentoDTO;

    }

}
