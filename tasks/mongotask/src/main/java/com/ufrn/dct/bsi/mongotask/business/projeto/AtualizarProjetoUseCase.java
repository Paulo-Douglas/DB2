package com.ufrn.dct.bsi.mongotask.business.projeto;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarProjetoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.ProjetoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AtualizarProjetoUseCase {
    private ProjetoRepository projetoRepository;
    private ProjetoMapper projetoMapper;

    public void executar(final String codProj, final CriarProjetoRequest request) {
        final var projeto = projetoRepository.findById(codProj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado"));

        projeto.setNomeProj(request.nomeProj());
        projeto.setDepto(request.depto());
        projeto.setLider(request.lider());
        projeto.setAlocacoes(request.alocacoes()
                .stream()
                .map(projetoMapper::toEntity)
                .toList());

        projetoRepository.save(projeto);
    }
}
