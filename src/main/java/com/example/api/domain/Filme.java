package com.example.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotEmpty(message = "campo titulo requerido")
    @Length(min = 3, max = 50, message = "o campo titulo deve ter entre 3-50 caracteres")
    String titulo;
    @NotEmpty(message = "campo diretor requerido")
    @Length(min = 3, max = 50, message = "o campo diretor deve ter entre 3-50 caracteres")
    String diretor;
    @NotEmpty(message = "campo resenha requerido")
    @Length(min = 10, max = 2000, message = "o campo resenha deve ter entre 10-2000 caracteres")
    String resenha;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    Categoria categoria;

}
