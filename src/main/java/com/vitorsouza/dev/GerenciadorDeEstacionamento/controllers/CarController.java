package com.vitorsouza.dev.GerenciadorDeEstacionamento.controllers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.CarDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.car.CarDuplicityValueException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.car.CarNotFoundException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.AllNotParamsException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.services.CarServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private final CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @PostMapping("/post")
    public ResponseEntity<String> addCar(@Valid @RequestBody CarDTO carDTO, BindingResult bindingResult){
        if(carServices.existsByPlaca(carDTO.getPlaca())){
            throw new CarDuplicityValueException();
        }

        if(bindingResult.hasErrors()){
            Map<String, String> erros = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                erros.put(error.getField(), error.getDefaultMessage());
            });
            throw new AllNotParamsException(HttpStatus.BAD_REQUEST, erros);
        }

        CarDTO car = carServices.addCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O carro: " + car.getModelo() + " foi adicionado com sucesso no ID: " + car.getId() + " na empresa de ID: " + car.getEmpresa().getId()) ;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CarDTO>> getCars(){
        List<CarDTO> carDTO = carServices.getCars();
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id){
        CarDTO carDTO = carServices.findCarById(id);
        if(carDTO == null){
            throw new CarNotFoundException();
        }

        return ResponseEntity.ok(carDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO){

        if (carServices.findCarById(id) == null){
            throw new CarNotFoundException();
        }
        if (carServices.existsByPlaca(carDTO.getPlaca())){
            throw new CarDuplicityValueException();
        }

        CarDTO carUpdated = carServices.updateCar(id, carDTO);
        return ResponseEntity.ok().body(carUpdated);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){

        if (carServices.findCarById(id) == null){
            throw new CarNotFoundException();
        }

        carServices.deleteCar(id);
        return ResponseEntity.ok("O carro com o ID: " + id + " foi excluído com sucesso.");

    }
}
