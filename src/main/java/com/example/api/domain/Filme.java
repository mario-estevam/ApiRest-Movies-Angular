package com.example.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String titulo;
    String diretor;
    String resenha;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    Categoria categoria;

}
