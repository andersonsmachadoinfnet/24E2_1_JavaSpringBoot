package br.anderson.infnet.appDr1Tp1.repository;

import br.anderson.infnet.appDr1Tp1.model.dominio.Paciente;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
}
