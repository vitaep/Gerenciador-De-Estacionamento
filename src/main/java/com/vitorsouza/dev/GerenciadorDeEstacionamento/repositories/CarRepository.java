package com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

    //Optional<CarModel> findCarByPlaca(String placa);

}
