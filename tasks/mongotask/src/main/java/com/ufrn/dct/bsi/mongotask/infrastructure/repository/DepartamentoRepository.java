package com.ufrn.dct.bsi.mongotask.infrastructure.repository;

import com.ufrn.dct.bsi.mongotask.infrastructure.entities.DepartamentoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartamentoRepository extends MongoRepository<DepartamentoEntity, String> {
}
