package br.com.fiap.fpf.fempowerfit.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "acompanhamento")
public class Acompanhamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{acompanhamento.descricao.notblank}")
    @Size(min = 3, message = "{acompanhamento.descricao.size}")
    private String descricao;

    @Positive


    private LocalDate data;

    private String tipo; //WheyProtein | Creatina | Pre-treino | Outros

    // Construtores, getters e setters aqui
}
