package com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.vaga;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_vaga")
public class VagaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "disponivel")
    private boolean disponivel;

}
