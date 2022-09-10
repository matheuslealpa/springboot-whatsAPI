package com.springbootwhatsapi.app.service;

import com.springbootwhatsapi.app.domain.Contato;
import com.springbootwhatsapi.app.repository.ContatoRepository;
import com.springbootwhatsapi.core.repository.datafilter.RSQLParam;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Getter
    private String entityNotFound = "Contato não encontrado.";
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato insert(Contato contato){
        return contatoRepository.save(contato);
    }

    public Page<Contato> findAll(RSQLParam q, Pageable pageable){
        return contatoRepository.findAll(q.getSpecification(), pageable);
    }

    public List<Contato> queryByNome(String nome){
        List<Contato> contatos = contatoRepository.findContatoByNomeLike(nome);
        return contatos.stream()
                .collect(Collectors.toList());
    }

    public Optional<Contato> findById(Long id){
        contatoRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException(getEntityNotFound()));
        return contatoRepository.findById(id);
    }

    public Contato update(Long id, Contato contato){
        contatoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(getEntityNotFound()));
        return contatoRepository.save(contato);
    }

    public void delete(Long id, Contato contato){
        contatoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(getEntityNotFound()));
        contatoRepository.delete(contato);
    }
}
