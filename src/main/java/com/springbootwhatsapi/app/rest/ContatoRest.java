package com.springbootwhatsapi.app.rest;

import com.springbootwhatsapi.app.domain.Contato;
import com.springbootwhatsapi.app.service.ContatoService;
import com.springbootwhatsapi.core.repository.datafilter.RSQLParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contatos")
public class ContatoRest {
    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato insert(@RequestBody Contato contato){
        return contatoService.insert(contato);
    }

    @GetMapping
    public Page<Contato> findAll(RSQLParam q, Pageable pageable){
        return contatoService.findAll(q, pageable);
    }

    @GetMapping("/nome/{nome}")
    public List<Contato> queryByNome(@PathVariable String nome){
        return contatoService.queryByNome(nome);
    }

    @GetMapping("/{id}")
    public Contato findById(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @PutMapping("/{id}")
    public Contato update(@PathVariable Long id){
        return contatoService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @RequestBody Contato contato){
        contatoService.delete(id, contato);
    }

}
