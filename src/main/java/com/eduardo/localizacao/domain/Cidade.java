package com.eduardo.localizacao.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_cidade")
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    private Long id;

    @Column(name = "nome", length = 50 )
    private String nome;

    @Column(name = "qtd_habitantes")
    private Long habitantes;
}
