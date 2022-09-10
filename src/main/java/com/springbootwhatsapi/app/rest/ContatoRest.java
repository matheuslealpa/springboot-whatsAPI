package com.springbootwhatsapi.app.rest;

import com.springbootwhatsapi.app.domain.Contato;
import com.springbootwhatsapi.app.service.ContatoService;
import com.springbootwhatsapi.core.repository.datafilter.RSQLParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Page<Contato>> findAll(RSQLParam q, Pageable pageable){
        return ResponseEntity.ok(contatoService.findAll(q, pageable));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Contato>> queryByNome(@PathVariable String nome){
        return ResponseEntity.ok(contatoService.queryByNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
        return ResponseEntity.ok(contatoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato){
        return ResponseEntity.ok(contatoService.update(id,contato));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @RequestBody Contato contato){
        contatoService.delete(id, contato);
    }

}
