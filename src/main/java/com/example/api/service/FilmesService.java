package com.example.api.service;

import com.example.api.domain.Categoria;
import com.example.api.domain.Filme;
import com.example.api.dto.CategoriaDTO;
import com.example.api.dto.FilmeDTO;
import com.example.api.excpetions.DataIntegrityViolationException;
import com.example.api.excpetions.ObjectNotFoundException;
import com.example.api.repository.CategoriaRepository;
import com.example.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    CategoriaService categoriaService;

    public Filme findById(Integer id){
        Optional<Filme> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado" + Filme.class.getName()));
    }

    public List<Filme> findAll(Integer id_cat){
    categoriaService.findById(id_cat);
    return repository.findAllByCategoriaIdOrderByTitulo(id_cat);
    }

    public Filme insert(Integer id_cat,Filme obj){
        obj.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        obj.setCategoria(cat);
        return repository.save(obj);
    }

    public Filme update(Integer id, Filme filme){
        Filme obj = findById(id);
        updateData(filme, obj);
        return repository.save(obj);
    }

    private void updateData(Filme filme, Filme obj) {
        obj.setTitulo(filme.getTitulo());
        obj.setCategoria(filme.getCategoria());
        obj.setDiretor(obj.getDiretor());
        obj.setResenha(obj.getResenha());
    }


    public void delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException exception){
            throw  new DataIntegrityViolationException("Categoria não pode ser deletado por possuir livros associados");
        }

    }

}
