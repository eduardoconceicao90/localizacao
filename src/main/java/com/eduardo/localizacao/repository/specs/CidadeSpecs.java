package com.eduardo.localizacao.repository.specs;

import com.eduardo.localizacao.domain.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeEqual(String nome){
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> habitantesGreaterThan(Integer value){
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), value);
    }
}
