package com.example.api.controller;

import com.example.api.domain.Filme;
import com.example.api.dto.FilmeDTO;
import com.example.api.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {


    @Autowired
    private FilmesService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Integer id){
        Filme obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        List<Filme> list = service.findAll(id_cat);
        List<FilmeDTO> listDto = list.stream().map(FilmeDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Filme> insert(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat, @RequestBody Filme obj){
        Filme newObj = service.insert(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> update(@PathVariable Integer id, @RequestBody Filme filme){
        Filme obj = service.update(id, filme);
        return ResponseEntity.ok().body(new FilmeDTO(obj));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> updatePatch(@PathVariable Integer id, @RequestBody Filme filme){
        Filme obj = service.update(id, filme);
        return ResponseEntity.ok().body(new FilmeDTO(obj));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
