package com.ufrn.dct.bsi.mongotask.business.departamento;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarDepartamentoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.DepartamentoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarDepartamentoUseCase {
    private DepartamentoRepository departamentoRepository;
    private DepartamentoMapper departamentoMapper;

    public void executar(final CriarDepartamentoRequest request) {
        final var departamento = departamentoMapper.toEntity(request);
        departamentoRepository.save(departamento);
    }
}
