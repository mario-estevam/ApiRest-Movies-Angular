package com.example.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotEmpty(message = "campo nome requerido")
    @Length(min = 3, max = 100, message = "o campo nome deve ter entre 3-100 caracteres")
    String nome;
    @NotEmpty(message = "campo Descrição requerido")
    @Length(min = 3, max = 200, message = "o campo Descrição deve ter entre 3-200 caracteres")
    String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    List<Filme> filmes = new ArrayList<>();

}
