package com.springbootwhatsapi.app.rest;

import com.springbootwhatsapi.app.domain.Contato;
import com.springbootwhatsapi.app.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contatos")
public class ContatoRest {
    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public Contato insert(Contato contato){
        return contatoService.insert(contato);
    }

    @GetMapping
    public List<Contato> findAll(){
        return contatoService.findAll();
    }

    @GetMapping
    public List<Contato> findContatoByNomeLike(String nome){
        return contatoService.findContatoByNomeLike(nome);
    }

    @GetMapping
    public Contato findContatoByEmail(String email){
        return contatoService.findContatoByEmail(email);
    }

    @GetMapping("/{id}")
    public Contato findById(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @PutMapping("/{id}")
    public Contato update(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestBody Contato contato){
        contatoService.delete(id, contato);
    }

}
