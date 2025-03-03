package com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

    boolean existsByCnpj (@Param("cnpj") String cnpj);

    boolean existsByNome (@Param("nome") String nome);

}
