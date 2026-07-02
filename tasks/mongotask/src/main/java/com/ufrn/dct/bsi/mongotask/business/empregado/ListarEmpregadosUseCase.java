package com.ufrn.dct.bsi.mongotask.business.empregado;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.EmpregadoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.EmpregadoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.EmpregadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarEmpregadosUseCase {
    private EmpregadoRepository empregadoRepository;
    private EmpregadoMapper empregadoMapper;

    public List<EmpregadoResponse> executar(){
        return empregadoRepository.findAll()
                .stream()
                .map(empregadoMapper::toResponse)
                .toList();
    }
}
