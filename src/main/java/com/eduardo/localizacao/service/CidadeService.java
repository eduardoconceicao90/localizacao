package com.eduardo.localizacao.service;

import com.eduardo.localizacao.domain.Cidade;
import com.eduardo.localizacao.repository.CidadeRepository;
import com.eduardo.localizacao.repository.specs.CidadeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void listarCidadesPorNomeSQL(){
        cidadeRepository.findByNomeSqlNativo("Salvador")
                .stream().map(cidadeProjection -> new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(), null))
                .forEach(System.out::println);
    }

    public void listarCidadesPorNome(){
        Pageable pageable = PageRequest.of(0, 3);
        cidadeRepository.findByNomeLike("%%%", pageable).forEach(System.out::println);
    }

    public void listarCidadesPorQuantidadeHabitantes(){
        cidadeRepository.findByHabitantesGreaterThan(1700000L).forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(){
        cidadeRepository.findByHabitantes(1653461L).forEach(System.out::println);
    }

    public void listarCidades(){
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);
    }

    public void listarCidadesByNomeSpecs(){
        Specification<Cidade> specs = CidadeSpecs.nomeEqual("Salvador")
                .or(CidadeSpecs.habitantesGreaterThan(1700000));
        cidadeRepository.findAll(specs).forEach(System.out::println);
    }
}
