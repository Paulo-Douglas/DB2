package com.ufrn.dct.bsi.mongotask.infrastructure.mappers;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarDepartamentoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.DepartamentoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.entities.DepartamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {
    @Mapping(target = "codDep", ignore = true)
    DepartamentoEntity toEntity(CriarDepartamentoRequest request);

    DepartamentoResponse toResponse(DepartamentoEntity departamento);
}
