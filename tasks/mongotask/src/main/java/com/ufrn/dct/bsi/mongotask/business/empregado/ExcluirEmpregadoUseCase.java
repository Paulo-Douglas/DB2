package com.ufrn.dct.bsi.mongotask.business.empregado;

import com.ufrn.dct.bsi.mongotask.infrastructure.repository.EmpregadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ExcluirEmpregadoUseCase {
    private EmpregadoRepository empregadoRepository;

    public void executar(final String id){
        if (!empregadoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado não encontrado");
        }

        empregadoRepository.deleteById(id);
    }
}
