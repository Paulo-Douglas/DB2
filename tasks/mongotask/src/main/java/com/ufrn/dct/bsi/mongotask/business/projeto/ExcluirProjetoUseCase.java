package com.ufrn.dct.bsi.mongotask.business.projeto;

import com.ufrn.dct.bsi.mongotask.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ExcluirProjetoUseCase {
    private ProjetoRepository projetoRepository;

    public void executar(final String codProj) {
        if (!projetoRepository.existsById(codProj)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado");
        }

        projetoRepository.deleteById(codProj);
    }
}
