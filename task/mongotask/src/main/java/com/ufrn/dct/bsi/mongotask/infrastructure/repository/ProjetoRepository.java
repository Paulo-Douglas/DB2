package com.ufrn.dct.bsi.mongotask.infrastructure.repository;

import com.ufrn.dct.bsi.mongotask.infrastructure.entities.ProjetoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjetoRepository extends MongoRepository<ProjetoEntity, String> {
}
