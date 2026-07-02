package com.ufrn.dct.bsi.mongotask.business.projeto;

import com.ufrn.dct.bsi.mongotask.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverAlocacaoProjetoUseCase {
    private ProjetoRepository projetoRepository;

    public void executar(final String codProj, final String empregado) {
        final var projeto = projetoRepository.findById(codProj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado"));

        final var alocacoes = Optional.ofNullable(projeto.getAlocacoes()).orElseGet(ArrayList::new);
        final var removido = alocacoes
                .removeIf(alocacao -> alocacao.getEmpregado().equals(empregado));

        if (!removido) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alocação não encontrada");
        }

        projeto.setAlocacoes(alocacoes);
        projetoRepository.save(projeto);
    }
}
