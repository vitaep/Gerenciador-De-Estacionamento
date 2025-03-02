package com.vitorsouza.dev.GerenciadorDeEstacionamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_cars")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "marca")
    String marca;

    @Column(name = "modelo")
    String modelo;

    @Column(name = "cor")
    String cor;

    @Column(unique = true, name = "placa")
    String placa;

    @Column(name = "tipo")
    TipoDeVeiculo tipo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    EmpresaModel empresa;


}
