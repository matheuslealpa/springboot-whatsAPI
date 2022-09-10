package com.springbootwhatsapi.app.service;

import com.springbootwhatsapi.app.domain.Contato;
import com.springbootwhatsapi.app.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato insert(Contato contato){
        return contatoRepository.save(contato);
    }

    public List<Contato> findAll(){
        return contatoRepository.findAll();
    }

    public List<Contato> queryByNome(String nome){
        List<Contato> contatos = contatoRepository.findContatoByNomeLike(nome);
        return contatos.stream()
                .collect(Collectors.toList());
    }

    public void searchId(Long id){
        if (!contatoRepository.existsById(id)) throw
                new EntityNotFoundException("Contato não encontrado");
    }

    public Contato findById(Long id){
        searchId(id);
        return contatoRepository.findById(id).get();
    }

    public Contato update(Long id, Contato contato){
        searchId(id);
        return contatoRepository.save(contato);
    }

    public void delete(Long id, Contato contato){
        searchId(id);
        contatoRepository.delete(contato);
    }
}
