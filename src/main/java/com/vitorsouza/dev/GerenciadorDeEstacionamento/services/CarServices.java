package com.vitorsouza.dev.GerenciadorDeEstacionamento.services;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.CarDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.mappers.CarMapper;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.CarModel;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServices {

    @Autowired
    CarRepository carRepository;
    @Autowired
    CarMapper carMapper;

    public CarDTO addCar(CarDTO carDTO){ // ADICIONAR EMPRESA NO DATABASE (CREATE)
        CarModel carModel = carMapper.map(carDTO);
        carModel = carRepository.save(carModel);
        return carMapper.map(carModel);
    }

    public List<CarDTO> getCars(){     // LISTAR EMPRESAS (READ)
        List<CarModel> car = carRepository.findAll();
        return car.stream().map(carMapper::map).collect(Collectors.toList());
    }

    public CarDTO findCarById(Long id){ // LISTAR EMPRESA POR ID (READ, MAS POR ID)
        Optional<CarModel> car = carRepository.findById(id);
        return car.map(carMapper::map).orElse(null);
    }

    public CarDTO updateCar(Long id, CarDTO carDTO){ // ATUALIZAR EMPRESA POR ID (UPDATE)
        CarModel oldCar = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O carro com o ID: " + id + " não foi encontrado."));

        if (carDTO.getMarca() != null && !carDTO.getMarca().isEmpty()) {
            oldCar.setMarca(carDTO.getMarca());
        }
        if (carDTO.getModelo() != null && !carDTO.getModelo().isEmpty()) {
            oldCar.setModelo(carDTO.getModelo());
        }
        if (carDTO.getCor() != null && !carDTO.getCor().isEmpty()) {
            oldCar.setCor(carDTO.getCor());
        }
        if (carDTO.getPlaca() != null && !carDTO.getPlaca().isEmpty()) {
            oldCar.setPlaca(carDTO.getPlaca());
        }
        if (carDTO.getTipo() != null) {
            oldCar.setTipo(carDTO.getTipo());
        }
        if (carDTO.getEmpresa() != null) {
            oldCar.setEmpresa(carDTO.getEmpresa());
        }

        carRepository.save(oldCar);
        return carMapper.map(oldCar);
    }

    public void deleteCar(Long id){

        if(!carRepository.existsById(id)) {
            throw new EntityNotFoundException("O carro com o ID: " + id + " não foi encontrado.");
        } else {
            carRepository.deleteById(id);
        }

    }

    public boolean existsByPlaca(String placa){
        return carRepository.existsByPlaca(placa);
    }

}
