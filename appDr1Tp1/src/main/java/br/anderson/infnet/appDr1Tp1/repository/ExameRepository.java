package br.anderson.infnet.appDr1Tp1.repository;

import br.anderson.infnet.appDr1Tp1.model.dominio.Exame;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExameRepository extends CrudRepository<Exame, Integer> {
    @Query("from Exame e where e.usuario.id = :userId")
    List<Exame> obterLista(Integer userId, Sort sort);

    @Query("from Exame e")
    List<Exame> obterLista(Sort sort);
}
