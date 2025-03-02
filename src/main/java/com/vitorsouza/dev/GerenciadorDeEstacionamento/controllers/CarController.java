package com.vitorsouza.dev.GerenciadorDeEstacionamento.controllers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.CarDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.services.CarServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private final CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @PostMapping("/post")
    public ResponseEntity<String> addCar(@RequestBody CarDTO carDTO){
        CarDTO car = carServices.addCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O carro: " + car.getModelo() + " foi adicionado com sucesso no ID: " + car.getId()) ;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CarDTO>> getCars(){
        List<CarDTO> carDTO = carServices.getCars();
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id){
        CarDTO carDTO = carServices.findCarById(id);

        if(carDTO != null){
            return ResponseEntity.ok(carDTO);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O carro com o ID: " + id + " não foi encontrado.");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO){
        try{
            CarDTO carUpdated = carServices.updateCar(id, carDTO);
            return ResponseEntity.ok().body(carUpdated);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        try{
            carServices.deleteCar(id);
            return ResponseEntity.ok("O carro com o ID: " + id + " foi excluído com sucesso.");
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
