package com.vitorsouza.dev.GerenciadorDeEstacionamento.services;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.CarDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.mappers.EmpresaMapper;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaDuplicityValuesException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaServices {

    @Autowired // INJEÇÃO DE DEPENDÊNCIAS
    EmpresaRepository empresaRepository;
    @Autowired // INJEÇÃO DE DEPENDÊNCIAS
    EmpresaMapper empresaMapper;

    public EmpresaServices(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    public EmpresaDTO addEmpresa(EmpresaDTO empresaDTO){ // ADICIONAR EMPRESA NO DATABASE (CREATE)
        EmpresaModel empresaModel = empresaMapper.map(empresaDTO);
        empresaModel = empresaRepository.save(empresaModel);
        return empresaMapper.map(empresaModel);
    }

    public List<EmpresaDTO> getEmpresas(){     // LISTAR EMPRESAS (READ)
        List<EmpresaModel> empresa = empresaRepository.findAll();
        return empresa.stream().map(empresaMapper::map).collect(Collectors.toList());
    }

    public EmpresaDTO findEmpresaById(Long id){ // LISTAR EMPRESA POR ID (READ, MAS POR ID)
        Optional<EmpresaModel> empresa = empresaRepository.findById(id);
        return empresa.map(empresaMapper::map).orElse(null);
    }

    public EmpresaDTO updateEmpresa(Long id, EmpresaDTO empresaDTO){ // ATUALIZAR EMPRESA POR ID (UPDATE)
        EmpresaModel oldEmpresa = empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("A empresa com o ID: " + id + " não foi encontrada."));

        if (empresaDTO.getNome() != null && !empresaDTO.getNome().isEmpty()) {
            oldEmpresa.setNome(empresaDTO.getNome());
        }
        if (empresaDTO.getCnpj() != null && !empresaDTO.getCnpj().isEmpty()) {
            oldEmpresa.setCnpj(empresaDTO.getCnpj());
        }
        if (empresaDTO.getEndereco() != null && !empresaDTO.getEndereco().isEmpty()) {
            oldEmpresa.setEndereco(empresaDTO.getEndereco());
        }
        if (empresaDTO.getTelefone() != null && !empresaDTO.getTelefone().isEmpty()) {
            oldEmpresa.setTelefone(empresaDTO.getTelefone());
        }
        if (empresaDTO.getVagasMoto() != null) {
            oldEmpresa.setVagasMoto(empresaDTO.getVagasMoto());
        }
        if (empresaDTO.getVagasCarro() != null) {
            oldEmpresa.setVagasCarro(empresaDTO.getVagasCarro());
        }
        if (empresaDTO.getCarros() != null && !empresaDTO.getCarros().isEmpty()) {
            oldEmpresa.setCarros(empresaDTO.getCarros());
        }

        empresaRepository.save(oldEmpresa);
        return empresaMapper.map(oldEmpresa);
    }

    public void deleteEmpresa(Long id){

        if (!empresaRepository.existsById(id)){
            throw new EntityNotFoundException("A empresa com o ID: " + id + " não foi encontrada.");
        }
        empresaRepository.deleteById(id);
    }

    public boolean existsByNome(EmpresaDTO empresaDTO){
        return empresaRepository.existsByNome(empresaDTO.getNome());
    }

    public boolean existsByCnpj(EmpresaDTO empresaDTO){
        return empresaRepository.existsByCnpj(empresaDTO.getCnpj());
    }

}
