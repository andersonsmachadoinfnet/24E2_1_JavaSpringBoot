package br.anderson.infnet.appdr4at.model.repository;

import br.anderson.infnet.appdr4at.model.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
}
