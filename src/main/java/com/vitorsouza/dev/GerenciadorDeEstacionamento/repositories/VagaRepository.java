package com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.vaga.VagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, Long> {



}
