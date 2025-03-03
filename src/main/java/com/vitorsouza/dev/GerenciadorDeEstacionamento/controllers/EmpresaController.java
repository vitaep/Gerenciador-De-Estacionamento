package com.vitorsouza.dev.GerenciadorDeEstacionamento.controllers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaAllNotParamsException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaDuplicityValuesException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaHaveCarsAssigned;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.exceptions.empresa.EmpresaNotFoundException;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.repositories.EmpresaRepository;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.services.EmpresaServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private final EmpresaServices empresaServices;

    public EmpresaController(EmpresaServices empresaServices) {
        this.empresaServices = empresaServices;
    }

    @PostMapping("/post") // ADD EMPRESAS
    public ResponseEntity<String> addEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult bindingResult){
        if (empresaServices.existsByNome(empresaDTO)){
            throw new EmpresaDuplicityValuesException();
        }
        if(empresaServices.existsByCnpj(empresaDTO)){
            throw new EmpresaDuplicityValuesException();
        }
        if(bindingResult.hasErrors()){
            Map<String, String> erros = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                erros.put(error.getField(), error.getDefaultMessage());
            });
            throw new EmpresaAllNotParamsException(HttpStatus.BAD_REQUEST, erros);
        }

        EmpresaDTO empresa = empresaServices.addEmpresa(empresaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body("A empresa com o nome: " + empresa.getNome() + " foi criada com sucesso no ID: " + empresa.getId());

    }

    @GetMapping("/get") // GET EMPRESAS
    public ResponseEntity<List<EmpresaDTO>> getEmpresa(){
        List<EmpresaDTO> empresaDTO = empresaServices.getEmpresas();
        return ResponseEntity.ok(empresaDTO);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmpresaById(@PathVariable Long id){
        EmpresaDTO empresaDTO = empresaServices.findEmpresaById(id);

        if(empresaDTO == null){
            throw new EmpresaNotFoundException();
        }

        return ResponseEntity.ok(empresaDTO);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmpresa(@PathVariable Long id, @RequestBody EmpresaDTO empresaDTO){

        if(empresaServices.findEmpresaById(id) == null){
            throw new EmpresaNotFoundException();
        }

        EmpresaDTO empresaUpdated = empresaServices.updateEmpresa(id, empresaDTO);
        return ResponseEntity.ok().body(empresaUpdated);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id){
        EmpresaDTO empresaDTO = empresaServices.findEmpresaById(id);

        if(empresaDTO == null){
            throw new EmpresaNotFoundException();
        }

        if(!empresaDTO.getCarros().isEmpty()){
            throw new EmpresaHaveCarsAssigned();
        }

        empresaServices.deleteEmpresa(id);
        return ResponseEntity.ok("A empresa com o ID: " + id + " foi excluída com sucesso.");

    }
}
