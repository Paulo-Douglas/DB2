package com.ufrn.dct.bsi.mongotask.business.empregado;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarEmpregadoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.EmpregadoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.EmpregadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarEmpregadoUseCase {
    private EmpregadoRepository empregadoRepository;
    private EmpregadoMapper empregadoMapper;

    public void executar(final CriarEmpregadoRequest request){
        final var empregado = empregadoMapper.toEntity(request);
        empregadoRepository.save(empregado);
    }
}
