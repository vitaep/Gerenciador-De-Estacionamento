package com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.mappers;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.DTOs.EmpresaDTO;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {

    public EmpresaModel map(EmpresaDTO empresaDTO){

        EmpresaModel empresaModel = new EmpresaModel();

        empresaModel.setId(empresaDTO.getId());
        empresaModel.setNome(empresaDTO.getNome());
        empresaModel.setCnpj(empresaDTO.getCnpj());
        empresaModel.setEndereco(empresaDTO.getEndereco());
        empresaModel.setTelefone(empresaDTO.getTelefone());
        empresaModel.setVagasMoto(empresaDTO.getVagasMoto());
        empresaModel.setVagasCarro(empresaDTO.getVagasCarro());
        empresaModel.setCarros(empresaDTO.getCarros());

        return empresaModel;

    }

    public EmpresaDTO map(EmpresaModel empresaModel){

        EmpresaDTO empresaDTO = new EmpresaDTO();

        empresaDTO.setId(empresaModel.getId());
        empresaDTO.setNome(empresaModel.getNome());
        empresaDTO.setCnpj(empresaModel.getCnpj());
        empresaDTO.setEndereco(empresaModel.getEndereco());
        empresaDTO.setTelefone(empresaModel.getTelefone());
        empresaDTO.setVagasMoto(empresaModel.getVagasMoto());
        empresaDTO.setVagasCarro(empresaModel.getVagasCarro());
        empresaDTO.setCarros(empresaModel.getCarros());


        return empresaDTO;

    }

}
