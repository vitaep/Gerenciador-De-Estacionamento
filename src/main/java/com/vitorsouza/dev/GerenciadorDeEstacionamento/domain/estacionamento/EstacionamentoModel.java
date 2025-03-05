package com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.estacionamento;


import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.car.CarModel;
import com.vitorsouza.dev.GerenciadorDeEstacionamento.domain.vaga.VagaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_estacionamento")
public class EstacionamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarModel car;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private VagaModel vaga;


}
