package com.example.api.dto;

import com.example.api.domain.Filme;

import java.io.Serializable;

public class FilmeDTO  implements Serializable {
    private static final long serialVersionUID= 1L;

    Integer id;
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
