package com.example.api.repository;

import com.example.api.domain.Filme;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    List<Filme> findAllByCategoriaIdOrderByTitulo(Integer id_cat);
}
