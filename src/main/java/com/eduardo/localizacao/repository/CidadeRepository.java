package com.eduardo.localizacao.repository;

import com.eduardo.localizacao.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
