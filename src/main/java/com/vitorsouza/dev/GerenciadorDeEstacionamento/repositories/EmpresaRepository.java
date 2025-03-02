package com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

    Optional<EmpresaModel> findEmpresaByCnpj (String cnpj);

    Optional<EmpresaModel> findEmpresaByName (String name);

}
