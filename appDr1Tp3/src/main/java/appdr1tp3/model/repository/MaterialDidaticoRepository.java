package appdr1tp3.model.repository;

import appdr1tp3.model.domain.MaterialDidatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, Integer> {
}
