package com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car;

import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.empresa.EmpresaModel;
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
    @Enumerated(EnumType.STRING)
    TipoDeVeiculo tipo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    EmpresaModel empresa;


}
