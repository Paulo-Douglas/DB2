package com.ufrn.dct.bsi.mongotask.business.projeto;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.ProjetoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.ProjetoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class BuscarProjetoUseCase {
    private ProjetoRepository projetoRepository;
    private ProjetoMapper projetoMapper;

    public ProjetoResponse executar(final String codProj) {
        final var projeto = projetoRepository.findById(codProj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado"));

        return projetoMapper.toResponse(projeto);
    }
}
