package com.ufrn.dct.bsi.mongotask.business.departamento;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarDepartamentoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AtualizarDepartamentoUseCase {
    private DepartamentoRepository departamentoRepository;

    public void executar(final String codDep, final CriarDepartamentoRequest request) {
        final var departamento = departamentoRepository.findById(codDep)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));

        departamento.setNomeDep(request.nomeDep());
        departamento.setGerente(request.gerente());

        departamentoRepository.save(departamento);
    }
}
