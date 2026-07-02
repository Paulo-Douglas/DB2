package com.ufrn.dct.bsi.mongotask.business.projeto;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.AlocacaoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.ProjetoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlocarEmpregadoProjetoUseCase {
    private ProjetoRepository projetoRepository;
    private ProjetoMapper projetoMapper;

    public void executar(final String codProj, final AlocacaoRequest request) {
        final var projeto = projetoRepository.findById(codProj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado"));

        final var alocacoes = new ArrayList<>(Optional.ofNullable(projeto.getAlocacoes()).orElseGet(ArrayList::new));
        alocacoes.removeIf(alocacao -> alocacao.getEmpregado().equals(request.empregado()));
        alocacoes.add(projetoMapper.toEntity(request));

        projeto.setAlocacoes(alocacoes);
        projetoRepository.save(projeto);
    }
}
