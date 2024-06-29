package br.anderson.infnet.appDr1Tp1.repository;

import br.anderson.infnet.appDr1Tp1.model.dominio.Procedimento;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProcedimentoRepository extends CrudRepository<Procedimento, Integer> {
    @Query("from Procedimento p where p.usuario.id = :userId")
    List<Procedimento> obterLista(Integer userId, Sort sort);

    @Query("from Procedimento p")
    List<Procedimento> obterLista(Sort sort);
}
