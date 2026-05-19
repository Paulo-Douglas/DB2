package com.ufrn.dct.bsi.mongotask.business.departamento;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.DepartamentoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.DepartamentoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class BuscarDepartamentoUseCase {
    private DepartamentoRepository departamentoRepository;
    private DepartamentoMapper departamentoMapper;

    public DepartamentoResponse executar(final String codDep) {
        final var departamento = departamentoRepository.findById(codDep)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));

        return departamentoMapper.toResponse(departamento);
    }
}
