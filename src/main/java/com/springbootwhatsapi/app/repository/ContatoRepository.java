package com.springbootwhatsapi.app.repository;

import com.springbootwhatsapi.app.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>, JpaSpecificationExecutor<Contato> {

    List<Contato> findContatoByNomeLike(String nome);

}
