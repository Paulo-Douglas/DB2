package com.ufrn.dct.bsi.mongotask.infrastructure.mappers;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarEmpregadoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.EmpregadoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.entities.EmpregadoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmpregadoMapper {
    @Mapping(target = "id", ignore = true)
    EmpregadoEntity toEntity(CriarEmpregadoRequest request);

    EmpregadoResponse toResponse(EmpregadoEntity empregado);
}
