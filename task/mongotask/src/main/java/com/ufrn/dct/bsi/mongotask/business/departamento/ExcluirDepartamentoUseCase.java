package com.ufrn.dct.bsi.mongotask.business.departamento;

import com.ufrn.dct.bsi.mongotask.infrastructure.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ExcluirDepartamentoUseCase {
    private DepartamentoRepository departamentoRepository;

    public void executar(final String codDep) {
        if (!departamentoRepository.existsById(codDep)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado");
        }

        departamentoRepository.deleteById(codDep);
    }
}
