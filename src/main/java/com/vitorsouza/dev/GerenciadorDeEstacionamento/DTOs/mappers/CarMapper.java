package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.mappers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.CarDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarModel map(CarDTO carDTO){

        CarModel carModel = new CarModel();

        carModel.setId(carDTO.getId());
        carModel.setMarca(carDTO.getMarca());
        carModel.setModelo(carDTO.getModelo());
        carModel.setCor(carDTO.getCor());
        carModel.setPlaca(carDTO.getPlaca());
        carModel.setTipo(carDTO.getTipo());
        carModel.setEmpresa(carDTO.getEmpresa());

        return carModel;

    }

    public CarDTO map(CarModel carModel){

        CarDTO carDTO = new CarDTO();

        carDTO.setId(carModel.getId());
        carDTO.setMarca(carModel.getMarca());
        carDTO.setModelo(carModel.getModelo());
        carDTO.setCor(carModel.getCor());
        carDTO.setPlaca(carModel.getPlaca());
        carDTO.setTipo(carModel.getTipo());
        carDTO.setEmpresa(carModel.getEmpresa());

        return carDTO;

    }

}
