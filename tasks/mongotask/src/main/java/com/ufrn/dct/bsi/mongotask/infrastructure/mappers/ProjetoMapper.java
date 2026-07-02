package com.ufrn.dct.bsi.mongotask.infrastructure.mappers;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.AlocacaoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.AlocacaoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarProjetoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.ProjetoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.entities.AlocacaoEmbedded;
import com.ufrn.dct.bsi.mongotask.infrastructure.entities.ProjetoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {
    @Mapping(target = "codProj", ignore = true)
    ProjetoEntity toEntity(CriarProjetoRequest request);

    ProjetoResponse toResponse(ProjetoEntity projeto);

    AlocacaoEmbedded toEntity(AlocacaoRequest request);

    AlocacaoResponse toResponse(AlocacaoEmbedded alocacao);
}
