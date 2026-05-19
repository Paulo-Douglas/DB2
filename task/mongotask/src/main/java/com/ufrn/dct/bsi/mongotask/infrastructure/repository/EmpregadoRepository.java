package com.ufrn.dct.bsi.mongotask.infrastructure.repository;

import com.ufrn.dct.bsi.mongotask.infrastructure.entities.EmpregadoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpregadoRepository extends MongoRepository<EmpregadoEntity, String> {
}
