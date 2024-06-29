package br.anderson.infnet.appDr1Tp1.repository;

import br.anderson.infnet.appDr1Tp1.model.dominio.Cirurgia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CirurgiaRepository extends CrudRepository<Cirurgia, Integer> {
    @Query("from Cirurgia c where c.usuario.id = :userId")
    List<Cirurgia> obterLista(Integer userId, Sort sort);

    @Query("from Cirurgia c ")
    List<Cirurgia> obterLista(Sort sort);
}
