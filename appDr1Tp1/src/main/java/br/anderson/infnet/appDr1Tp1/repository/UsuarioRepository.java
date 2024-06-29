package br.anderson.infnet.appDr1Tp1.repository;

import br.anderson.infnet.appDr1Tp1.model.dominio.Prontuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsuarioRepository  extends CrudRepository<Prontuario, Integer>  {
    @Query("from Prontuario p where p.usuario.id = :userId")
    List<Prontuario> obterLista(Integer userId , Sort sort);

    @Query("from Prontuario p")
    List<Prontuario> obterLista(Sort sort);
}
