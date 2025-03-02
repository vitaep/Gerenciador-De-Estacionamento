package com.vitorsouza.dev.GerenciadorDeEstacionamento.controllers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.services.EmpresaServices;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private final EmpresaServices empresaServices;

    public EmpresaController(EmpresaServices empresaServices) {
        this.empresaServices = empresaServices;
    }

    @PostMapping("/post") // ADD EMPRESAS
    public ResponseEntity<String> addEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO){
        EmpresaDTO empresa = empresaServices.addEmpresa(empresaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A empresa com o nome: " + empresa.getNome() + " foi criada com sucesso no ID: " + empresa.getId() );
    }

    @GetMapping("/get") // GET EMPRESAS
    public ResponseEntity<List<EmpresaDTO>> getEmpresa(){
        List<EmpresaDTO> empresaDTO = empresaServices.getEmpresas();
        return ResponseEntity.ok(empresaDTO);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmpresaById(@PathVariable Long id){
        EmpresaDTO empresaDTO = empresaServices.findEmpresaById(id);

        if(empresaDTO != null){
            return ResponseEntity.ok(empresaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A empresa com ID: " + id + " não foi encontrada.");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmpresa(@PathVariable Long id, @Valid @RequestBody EmpresaDTO empresaDTO){
       try {
           EmpresaDTO empresaUpdated = empresaServices.updateEmpresa(id, empresaDTO);
           return ResponseEntity.ok().body(empresaUpdated);
       } catch (EntityNotFoundException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body(e.getMessage());
       }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id){
        try {
            empresaServices.deleteEmpresa(id);
            return ResponseEntity.ok("A empresa com o ID: " + id + " foi excluída com sucesso.");
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
