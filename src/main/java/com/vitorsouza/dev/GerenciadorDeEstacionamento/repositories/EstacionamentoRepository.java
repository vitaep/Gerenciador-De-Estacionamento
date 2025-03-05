package com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.estacionamento.EstacionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamentoRepository extends JpaRepository<EstacionamentoModel, Long> {



}
