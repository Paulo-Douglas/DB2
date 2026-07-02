package com.ufrn.dct.bsi.mongotask.business.empregado;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.EmpregadoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.EmpregadoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.EmpregadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class BuscarEmpregadoUseCase {
    private EmpregadoRepository empregadoRepository;
    private EmpregadoMapper empregadoMapper;

    public EmpregadoResponse executar(final String id){
        final var empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado não encontrado"));

        return empregadoMapper.toResponse(empregado);
    }
}
