package com.example.api.dto;

import com.example.api.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID= 1L;

    private Integer id;
    @NotEmpty(message = "campo nome requerido")
    @Length(min = 3, max = 100, message = "o campo nome deve ter entre 3-100 caracteres")
    String nome;
    @NotEmpty(message = "campo Descrição requerido")
    @Length(min = 3, max = 200, message = "o campo Descrição deve ter entre 3-200 caracteres")
    String descricao;

    public CategoriaDTO() {
       super();
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
