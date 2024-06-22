package br.anderson.infnet.appdr4at.model.repository;

import br.anderson.infnet.appdr4at.model.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
