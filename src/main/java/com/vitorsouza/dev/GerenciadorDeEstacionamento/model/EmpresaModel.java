package com.vitorsouza.dev.GerenciadorDeEstacionamento.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_empresa")
public class EmpresaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, name = "nome")
    private String nome;

    @Column(unique = true, name = "cnpj")
    private String cnpj;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "vagas_moto")
    private int vagasMoto;

    @Column(name = "vagas_carro")
    private int vagasCarro;

    @OneToMany(mappedBy = "empresa")
    private List<CarModel> carros;

}
