package br.anderson.infnet.appdr4at.model.repository;

import br.anderson.infnet.appdr4at.model.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
