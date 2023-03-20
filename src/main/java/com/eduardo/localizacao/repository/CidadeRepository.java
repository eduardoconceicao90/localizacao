package com.eduardo.localizacao.repository;

import com.eduardo.localizacao.domain.Cidade;
import com.eduardo.localizacao.repository.projections.CidadeProjection;
import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    @Query(nativeQuery = true, value = " select c.id_cidade as id, c.nome from tb_cidade as c where c.nome =:nome ") // SQL NATIVO
    List<CidadeProjection> findByNomeSqlNativo(@Param("nome") String nome);

    // busca pelo nome like ordenado
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ") // HQL
    List<Cidade> findByNomeLike(String nome, Sort sort);

    // busca pelo nome like paginado
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ") // HQL
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

    /* ---- Query Methods ---- */

    // busca pelo nome correto
    List<Cidade> findByNome(String nome);

    // busca pelo nome começando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    // busca pelo nome terminando por aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    // busca pelo nome contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);
}
