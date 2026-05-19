package com.ufrn.dct.bsi.mongotask.business.departamento;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.DepartamentoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.DepartamentoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarDepartamentosUseCase {
    private DepartamentoRepository departamentoRepository;
    private DepartamentoMapper departamentoMapper;

    public List<DepartamentoResponse> executar() {
        return departamentoRepository.findAll()
                .stream()
                .map(departamentoMapper::toResponse)
                .toList();
    }
}
