package com.vitorsouza.dev.GerenciadorDeEstacionamento.controllers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.services.EmpresaServices;
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
    public ResponseEntity<String> addEmpresa(@RequestBody EmpresaDTO empresaDTO){
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

    @PutMapping("/get/{id}")
    public ResponseEntity<?> updateEmpresa(@PathVariable Long id, EmpresaDTO empresaDTO){
        EmpresaDTO empresa = empresaServices.updateEmpresa(id, empresaDTO);

        if(empresa != null){
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A empresa com ID: " + id + " não foi encontrada");
        }


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id){


        if(empresaServices.findEmpresaById(id) != null){
            empresaServices.deleteEmpresa(id);
            return ResponseEntity.ok("A empresa com o ID: " + id + " foi excluida com sucesso.");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A empresa com o ID: " + id + " não foi encontrada.");
    }

}
