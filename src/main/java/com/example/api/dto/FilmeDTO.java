package com.example.api.dto;

import com.example.api.domain.Filme;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class FilmeDTO  implements Serializable {
    private static final long serialVersionUID= 1L;

    Integer id;
    @NotEmpty(message = "campo titulo requerido")
    @Length(min = 3, max = 50, message = "o campo titulo deve ter entre 3-50 caracteres")
    String titulo;

    public FilmeDTO() {
        super();
    }


    public FilmeDTO(Filme obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
